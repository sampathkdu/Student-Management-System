package com.example.CRUD_application.controller;
import com.example.CRUD_application.model.Student;
import com.example.CRUD_application.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/api/students")
@CrossOrigin(origins = "*")

public class StudentController {
    @Autowired
    private StudentService studentService;
    @PostMapping
    public ResponseEntity<Student> saveEmployee(@RequestBody Student student){
    return new 
   ResponseEntity<Student>(studentService.saveStudent(student),HttpStatus.CREATED);
    }

    //GetAll Rest Api
    @GetMapping
    public List<Student> getAllStudent(){
    return studentService.getAllStudent();
    }

    //Get by Id Rest Api
    @GetMapping("{id}")
    // localhost:8080/api/students/1
    public ResponseEntity<Student> getEmployeeById(@PathVariable("id") long studentID){
    return new ResponseEntity<Student>(studentService.getStudentById(studentID),HttpStatus.OK);
    }

    //Update Rest Api
    @PutMapping("{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable("id") long id,@RequestBody Student student){
    return new ResponseEntity<Student>(studentService.updateStudent(student,id),HttpStatus.OK);
    }

    //Delete Rest Api
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable("id") long id){
    //delete student from db
    studentService.deleteStudent(id);
    return new ResponseEntity<String>("Student deleted Successfully.",HttpStatus.OK);
    }

    @GetMapping("/YearOfEnrollment/{year}")
    public ResponseEntity<List<Student>> getStudentsByYearOfEnrollment(@PathVariable("year") String yearOfEnrollment) {
    List<Student> students = studentService.getStudentsByYearOfEnrollment(yearOfEnrollment);
    return new ResponseEntity<>(students, HttpStatus.OK);
    }

    @GetMapping("/{id}/department")
    public ResponseEntity<String> getDepartmentByStudentId(@PathVariable("id") long id) {
    String department = studentService.getDepartmentByStudentId(id);
    return new ResponseEntity<>(department, HttpStatus.OK);
    }

    @DeleteMapping("/year-of-enrollment/{year}")
    public ResponseEntity<String> deleteStudentsByYearOfEnrollment(@PathVariable("year") String yearOfEnrollment) {
    studentService.deleteStudentsByYearOfEnrollment(yearOfEnrollment);
    return new ResponseEntity<>("Students enrolled in " + yearOfEnrollment + " have been deleted successfully.", HttpStatus.OK);
    }
    




}
