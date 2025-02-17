package org.deneme.studentsbackend.controller;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.deneme.studentsbackend.exception.ResourceNotFoundException;
import org.deneme.studentsbackend.model.Student;
import org.deneme.studentsbackend.repository.StudentRepository;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class StudentController {
    @Autowired
    private StudentRepository studentRepository;

    @GetMapping("/students")
    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }
    @PostMapping("/students")
    public Student createStudent(@RequestBody Student student) {
        return studentRepository.save(student);
    }

    @GetMapping("/students/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Long id) {
        Student student = studentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Student can not find yanlış oldu cümle" + id));
        return ResponseEntity.ok(student);
    }

    @PutMapping("/students/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable long id, @RequestBody Student studentDetails) {
        Student student = studentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Student can not find yanlış oldu cümle" + id));
        student.setStudentName(studentDetails.getStudentName());
        student.setStudentSurname(studentDetails.getStudentSurname());
        student.setStudentId(studentDetails.getStudentId());
        student.setClassName(studentDetails.getClassName());

        Student updatedStudent = studentRepository.save(student);
        return ResponseEntity.ok(updatedStudent);
    }

    @DeleteMapping("/student/{id}")
    public ResponseEntity<Map<String,Boolean>> deleteStudent(@PathVariable long id) {
        Student student = studentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Student can not find yanlış oldu cümle" + id));
        studentRepository.delete(student);
        Map<String,Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}
