package com.student.controller;

import com.student.enumeration.ResponseStatus;
import com.student.model.Student;
import com.student.response.CommonResponse;
import com.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/student")
public class StudentController {

    @Autowired
    private StudentService studentrespository;

    @PostMapping
    public ResponseEntity<CommonResponse> createStudent(@RequestBody Student student){
        Student created=studentrespository.createStudent(student);
        CommonResponse response=new CommonResponse();
        response.setStatus(ResponseStatus.SUCCESS);
        response.setSuccessMessage("Student Created Successfully");
        response.setData(created);
        response.setCode(201);
        return ResponseEntity.status(201).body(response);
    }

}
