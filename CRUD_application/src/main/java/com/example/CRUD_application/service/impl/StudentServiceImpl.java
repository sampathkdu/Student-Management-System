package com.example.CRUD_application.service.impl;
import com.example.CRUD_application.model.Student;
import com.example.CRUD_application.repository.StudentRepository;
import com.example.CRUD_application.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository studentRepsitory;

    //save student in database
    @Override
    public Student saveStudent(Student student){
    return studentRepsitory.save(student);
    }

    //get all student form database
    @Override
    public List<Student> getAllStudent() {
    return studentRepsitory.findAll();
    }

    //get student using id
    @Override
    public Student getStudentById(long id) {
    Optional<Student> student = studentRepsitory.findById(id);
    if(student.isPresent()){
    return student.get();
    }else {
    throw new RuntimeException();
    }
    }

    //update student
    @Override
    public Student updateStudent(Student student, long id) {
    Student existingStudent = studentRepsitory.findById(id).orElseThrow(
    ()-> new RuntimeException()
    );
    existingStudent.setFirstName(student.getFirstName());
    existingStudent.setLastName(student.getLastName());
    existingStudent.setEmail(student.getEmail());
    existingStudent.setDepartment(student.getDepartment());
    existingStudent.setYearOfEnrollment(student.getYearOfEnrollment());
    
    // save
    studentRepsitory.save(existingStudent);
    return existingStudent;
    }

    //delete student
    @Override
    public void deleteStudent(long id) {
    //check
    studentRepsitory.findById(id).orElseThrow(()-> new 
    RuntimeException());
    //delete
    studentRepsitory.deleteById(id);
    }
   
    //retrive student by year of Enrollment
    @Override
    public List<Student> getStudentsByYearOfEnrollment(String yearOfEnrollment) {
    return studentRepsitory.findByYearOfEnrollment(yearOfEnrollment);
    }

    //retrive student department by id
    @Override
    public String getDepartmentByStudentId(long id) {
    return studentRepsitory.findDepartmentByStudentId(id);
    }

    //Delete Student By YearOfEnrollment
    @Override
    @Transactional
    public void deleteStudentsByYearOfEnrollment(String yearOfEnrollment) {
    studentRepsitory.deleteByYearOfEnrollment(yearOfEnrollment);
    }



}
