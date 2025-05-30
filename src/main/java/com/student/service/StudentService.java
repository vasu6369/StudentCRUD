package com.student.service;

import com.student.model.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    public Student createStudent(Student student);
    public List<Student> getAllStudents();
    public Optional<Student> getStudentById(String id);

}
