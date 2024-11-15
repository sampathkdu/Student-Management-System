package com.example.CRUD_application.repository;
import com.example.CRUD_application.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


public interface StudentRepository  extends JpaRepository<Student,Long> {
   
    //Retrive by Enrollment year
    List<Student> findByYearOfEnrollment(String yearOfEnrollment);

    //Retrive Departmet By id
    @Query("SELECT s.department FROM Student s WHERE s.id = :id")String findDepartmentByStudentId(@Param("id") long id);
    
    //delete student by year
    @Modifying
    @Transactional
    @Query("DELETE FROM Student s WHERE s.yearOfEnrollment = :yearOfEnrollment")
    void deleteByYearOfEnrollment(@Param("yearOfEnrollment") String yearOfEnrollment);

}

