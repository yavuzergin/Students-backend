package org.deneme.studentsbackend.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import org.deneme.studentsbackend.model.Student;
@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{

}
