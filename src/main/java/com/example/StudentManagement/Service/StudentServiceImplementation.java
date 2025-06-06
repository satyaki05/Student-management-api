package com.example.StudentManagement.Service;

import com.example.StudentManagement.model.Student;
import com.example.StudentManagement.repository.StudentJPARepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// Marks this class as a service so Spring knows it provides business logic
@Service
public class StudentServiceImplementation implements StudentService {

    // Inject the repository to perform database operations
    @Autowired
    private StudentJPARepository repository;

    // Save a new student to the database
    @Override
    public Student saveStudent(Student student) {
        return repository.save(student); // Save and return the saved student
    }

    // Get a student by ID
    @Override

    public Optional<Student> getStudent(Long id) {

        return repository.findById(id);
// Return student if found, else null
    }

    // Get all students from the database
    @Override
    public List<Student> getAllStudents() {
        return repository.findAll(); // Return all students
    }


    // Update a student's information
    @Override
    public Student updateStudent(Long id, Student student) {
        student.setId(id); // Set the correct ID before saving
        return repository.save(student); // Save updated student
    }

    // Delete a student by ID
    @Override
    public void deleteStudent(Long id) {
        repository.deleteById(id);
    }

}
