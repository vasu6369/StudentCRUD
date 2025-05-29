package com.student.model;

import jdk.jfr.DataAmount;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@Document(collection = "student")
public class Student {
    @Id
    private String id;
    private String name;
    private String email;
    private int age;
}
