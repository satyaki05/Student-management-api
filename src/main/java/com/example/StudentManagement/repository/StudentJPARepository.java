package com.example.StudentManagement.repository;

import com.example.StudentManagement.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
public interface StudentJPARepository extends JpaRepository<Student, Long> {



}