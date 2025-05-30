package com.student.service;

import com.student.model.Student;
import com.student.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    private StudentRepository studentrespository;


    @Override
    public Student createStudent(Student student){
        return studentrespository.save(student);
    }

    @Override
    public List<Student> getAllStudents(){
        return studentrespository.findAll();
    }

    @Override
    public Optional<Student> getStudentById(String id){
        return studentrespository.findById(id);
    }



}
