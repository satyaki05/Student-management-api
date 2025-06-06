package com.example.StudentManagement.controller;


import com.example.StudentManagement.Service.StudentService;
import com.example.StudentManagement.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/students")
public class StudentController {
    @Autowired
    private StudentService studentService;
    @PostMapping
    public Student saveStudent(@RequestBody Student student) {
        return studentService.saveStudent(student);

    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Student>> getStudent(@PathVariable Long id) {
        Optional<Student> student = studentService.getStudent(id);
        if (student != null) {
            return ResponseEntity.ok(student);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }


    public List<Student> getAllStudents() {
        return studentService.getAllStudents();

    }
    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable Long id, @RequestBody Student student) {
        Student updatedStudent = studentService.updateStudent(id, student);
        if (updatedStudent != null) {
            return ResponseEntity.ok(updatedStudent);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable Long id)  {
        Optional<Student> student = studentService.getStudent(id);
        if (student.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Student not found");
        }
        studentService.deleteStudent(id);
        return ResponseEntity.ok("Student with id " + id + " deleted successfully");
    }



}
