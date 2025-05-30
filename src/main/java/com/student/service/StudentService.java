package com.student.service;

import com.student.model.Student;

import java.util.List;

public interface StudentService {
    public Student createStudent(Student student);
    public List<Student> getAllStudents();
}
