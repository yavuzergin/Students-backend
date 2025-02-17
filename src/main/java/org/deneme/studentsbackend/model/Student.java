package org.deneme.studentsbackend.model;
import jakarta.persistence.*;
@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "student_name")
    private String studentName;
    @Column(name = "student_surname")
    private String studentSurname;
    @Column(name = "student_id")
    private int studentId;

    @Column(name = "class")
    private String className;

    public Student () {

    }
    public Student(String studentName, String studentSurname, Integer studentId, String className) {
        this.studentName = studentName;
        this.studentSurname = studentSurname;
        this.studentId = studentId;
        this.className = className;
    }

    public long getId(){
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getStudentName(){
        return studentName;
    }
    public void setStudentName (String studentName) {
        this.studentName = studentName;
    }
    public String getStudentSurname(){
        return studentSurname;
    }
    public void setStudentSurname (String studentSurname) {
        this.studentSurname = studentSurname;
    }
    public int getStudentId() {
        return studentId;
    }
    public void setStudentId(int studentId){
        this.studentId = studentId;
    }
    public String getClassName() {
        return className;
    }
    public void setClassName(String className){
        this.className = className;
    }


}
