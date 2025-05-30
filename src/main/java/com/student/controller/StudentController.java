package com.student.controller;

import com.student.enumeration.ResponseStatus;
import com.student.model.Student;
import com.student.response.CommonResponse;
import com.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping
    public ResponseEntity<CommonResponse> createStudent(@RequestBody Student student){
        Student created=studentService.createStudent(student);
        CommonResponse response=new CommonResponse();
        response.setStatus(ResponseStatus.SUCCESS);
        response.setSuccessMessage("Student Created Successfully");
        response.setData(created);
        response.setCode(201);
        return ResponseEntity.status(201).body(response);
    }

    @GetMapping
    public ResponseEntity<CommonResponse> getAllStudents(){
        List<Student> students=studentService.getAllStudents();
        CommonResponse response=new CommonResponse();
        response.setStatus(ResponseStatus.SUCCESS);
        response.setSuccessMessage("Fetched All Students");
        response.setData(students);
        response.setCode(200);
        return ResponseEntity.ok(response);
    }

}
