package com.student.controller;

import com.student.enumeration.ResponseStatus;
import com.student.model.Student;
import com.student.response.CommonResponse;
import com.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/student")
public class StudentController {

    @Autowired
    private StudentService studentservice;

    @PostMapping
    public ResponseEntity<CommonResponse> createStudent(@RequestBody Student student){
        Student created=studentservice.createStudent(student);
        CommonResponse response=new CommonResponse();
        response.setStatus(ResponseStatus.SUCCESS);
        response.setSuccessMessage("Student Created Successfully");
        response.setData(created);
        response.setCode(201);
        return ResponseEntity.status(201).body(response);
    }

    @GetMapping
    public ResponseEntity<CommonResponse> getAllStudents(){
        List<Student> students=studentservice.getAllStudents();
        CommonResponse response=new CommonResponse();
        response.setStatus(ResponseStatus.SUCCESS);
        response.setSuccessMessage("Fetched All Students");
        response.setData(students);
        response.setCode(200);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CommonResponse> getStudentById(@PathVariable String id){
        Optional<Student> student=studentservice.getStudentById(id);
        CommonResponse response=new CommonResponse();
        if(student.isPresent()){
            response.setStatus(ResponseStatus.SUCCESS);
            response.setSuccessMessage("Student Fetched");
            response.setData(student);
            response.setCode(200);
            return ResponseEntity.ok(response);
        }
        else{
            response.setStatus(ResponseStatus.FAILED);
            response.setErrorMessage("Student Not Found");
            response.setCode(404);
            return ResponseEntity.status(404).body(response);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<CommonResponse> updateStudent(@PathVariable String id,@RequestBody Student student) {
        try {
            Student updated = studentservice.updateStudent(id, student);
            CommonResponse response = new CommonResponse();
            response.setStatus(ResponseStatus.SUCCESS);
            response.setData(updated);
            response.setSuccessMessage("Student updated.");
            response.setCode(200);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            CommonResponse response = new CommonResponse();
            response.setStatus(ResponseStatus.FAILED);
            response.setErrorMessage("Update failed: " + e.getMessage());
            response.setCode(500);
            return ResponseEntity.status(500).body(response);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CommonResponse> deleteStudentById(@PathVariable String id){
        try{
            studentservice.deleteStudentById(id);
            CommonResponse response = new CommonResponse();
            response.setStatus(ResponseStatus.SUCCESS);
            response.setSuccessMessage("Student Deleted.");
            response.setCode(200);
            return ResponseEntity.ok(response);
        }catch (Exception e){
            CommonResponse response = new CommonResponse();
            response.setStatus(ResponseStatus.FAILED);
            response.setErrorMessage("Delete failed: " + e.getMessage());
            response.setCode(500);
            return ResponseEntity.status(500).body(response);
        }
    }
}
