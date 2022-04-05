package com.example.springstudent.repository;


import com.example.springstudent.model.Student;

import java.util.HashMap;
import java.util.Map;

public class StudentRepository {

    Map<String, Student> studentMap = new HashMap<>();

    public StudentRepository(){}

    public Student addStudent(Student student){
        String id = student.getId();
        studentMap.put(id, student);
        return student;
    }

    public Student getById(String id){
        return studentMap.get(id);
    }

}
