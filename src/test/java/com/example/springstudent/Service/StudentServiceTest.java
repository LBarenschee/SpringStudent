package com.example.springstudent.Service;

import com.example.springstudent.model.Student;
import com.example.springstudent.repository.StudentRepository;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class StudentServiceTest {

    private StudentRepository studentRepo = mock(StudentRepository.class);
    private StudentService studentService = new StudentService(studentRepo);



    @Test
    void getStudentById_whenId1_thenReturnStudentWithId1() {
    //GIVEN
    when(studentRepo.getById("1")).thenReturn(new Student("Florian", "1"));

    //WHEN
    Student actual = studentService.getStudentById("1");

    //THEN
    Student expected = new Student("Florian", "1");
    verify(studentRepo).getById("1");
    assertEquals(expected, actual);
    }

    @Test
    void addStudent(){
    //GIVEN
    when(studentRepo.addStudent(new Student("Samson", "555"))).thenReturn(new Student("Samson", "555"));
    //WHEN
    Student actual = studentService.addStudent(new Student("Samson", "555"));
    //THEN
    Student expected = new Student("Samson", "555");

    verify(studentRepo).addStudent(new Student("Samson", "555"));
    assertEquals(expected, actual);

    }


    @Test
    void deleteStudent(){
    //GIVEN
    when(studentRepo.deleteStudent("2")).thenReturn(new Student("Deleted Student", "2"));

    //WHEN
    Student actual = studentService.deleteStudent("2");

    //THEN
    Student expected = new Student("Deleted Student", "2");

    verify(studentRepo).deleteStudent("2");
    assertEquals(expected, actual);
    }


    @Test
    void getAllStudents() {
        //GIVEN

        //WHEN

        //THEN
    }

    @Test
    void getStudentByName() {
        //GIVEN
        when(studentRepo.getAllStudents()).thenReturn(List.of(new Student("Florian", "id"), new Student("Matthias", "2")));

        //WHEN
        List<Student> actual = studentService.getStudentByName("Matthias");

        //THEN
        List<Student> expected = List.of(new Student("Matthias", "2"));

        verify(studentRepo).getAllStudents();
        assertEquals(expected, actual);
    }


}