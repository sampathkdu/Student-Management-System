package com.example.CRUD_application.repository;
import com.example.CRUD_application.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;


public interface StudentRepsitory  extends JpaRepository<Student,Long> {
    //crud
}
