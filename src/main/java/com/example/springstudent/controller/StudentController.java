package com.example.springstudent.controller;

import com.example.springstudent.Service.StudentService;
import com.example.springstudent.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("student") // http://localhost:8080/student

public class StudentController {

    private final StudentService service;

    @Autowired
    public StudentController(StudentService service) {
        this.service = service;
    }



    @GetMapping(path = "{id}")
    public Student getStudentById(@PathVariable String id){
        return service.getStudentById(id);
    }

    @GetMapping
    public List<Student> getAllStudents(){
        return service.getAllStudents();
    }
    @PostMapping
    public Student addStudent(@RequestBody Student student){
        Student addedStudent =  service.addStudent(student);
        return addedStudent;
    }

    @DeleteMapping(path = "{id}")
    public void deleteStudent(@PathVariable String id){
        service.deleteStudent(id);
    }
}
