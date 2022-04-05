package com.example.springstudent.Service;


import com.example.springstudent.model.Student;
import com.example.springstudent.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

    private final StudentRepository repo;

    @Autowired
    public StudentService(StudentRepository repo) {
        this.repo = repo;
    }

    public Student getStudentById(String id){
        return repo.getById(id);
    }

    public Student addStudent(Student student){
        Student student1 = repo.addStudent(student);
        return student1;
    }

    public Student deleteStudent(String id) {
       return repo.deleteStudent(id);
    }

    public List<Student> getAllStudents() {
        return repo.getAllStudents();
    }

    public List<Student> getStudentByName(String name){
        List<Student> allStudents = repo.getAllStudents();
        List<Student> studentsWithName = new ArrayList<>();

        for(Student currentStudent: allStudents){
            if(currentStudent.getName().equals(name)){
                studentsWithName.add(currentStudent);
            }
        }
        return studentsWithName;
    }
}
