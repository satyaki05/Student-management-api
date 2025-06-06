package com.example.StudentManagement.Service;

import com.example.StudentManagement.model.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    public Student saveStudent(Student student);
    public List<Student> getAllStudents();
    public Optional<Student> getStudent(Long id);
    public void deleteStudent(Long id);
    public Student updateStudent( Long id,Student student);



}
