package com.example.springstudent.controller;

import com.example.springstudent.Service.StudentService;
import com.example.springstudent.model.Student;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("student") // http://localhost:8080/student

public class StudentController {

    private final StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    @GetMapping
    public List<Student> getStudentList(){
       return List.of(new Student("Anna", "1234"), new Student("Caesar", "4321"));
    }

    @GetMapping(path = "{id}")
    public Student getStudentById(@PathVariable String id){
        return service.getStudentById(id);
    }

    @PostMapping
    public Student addStudent(@RequestBody Student student){
        Student addedStudent =  service.addStudent(student);
        return addedStudent;
    }

}
