package com.student.service;

import com.student.model.Student;
import com.student.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public  class StudentServiceImpl implements StudentService{

    @Autowired
    private StudentRepository studentrepository;


    @Override
    public Student createStudent(Student student){
        return studentrepository.save(student);
    }

    @Override
    public List<Student> getAllStudents(){
        return studentrepository.findAll();
    }

    @Override
    public Optional<Student> getStudentById(String id){
        return studentrepository.findById(id);
    }

    @Override
    public Student updateStudent(String id, Student studentDetails) {
        Student student=studentrepository.findById(id).orElseThrow();
        student.setName(studentDetails.getName());
        student.setEmail(studentDetails.getEmail());
        student.setAge(studentDetails.getAge());
        return studentrepository.save(student);
    }

}
