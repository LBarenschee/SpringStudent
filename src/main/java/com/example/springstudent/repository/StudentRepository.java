package com.example.springstudent.repository;


import com.example.springstudent.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class StudentRepository {

    Map<String, Student> studentMap = new HashMap<>();

    @Autowired
    public StudentRepository(){}

    public Student addStudent(Student student){
        String id = student.getId();
        studentMap.put(id, student);
        return student;
    }

    public Student getById(String id){
        return studentMap.get(id);
    }

    public Student deleteStudent(String id) {
       return studentMap.remove(id);
    }

    public List<Student> getAllStudents() {
        return List.copyOf(studentMap.values());
    }
}
