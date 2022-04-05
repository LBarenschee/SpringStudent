package com.example.springstudent.Service;


import com.example.springstudent.model.Student;
import com.example.springstudent.repository.StudentRepository;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    StudentRepository repo = new StudentRepository();

    public Student getStudentById(String id){
        return repo.getById(id);
    }

    public Student addStudent(Student student){
        Student student1 = repo.addStudent(student);
        return student1;
    }
}
