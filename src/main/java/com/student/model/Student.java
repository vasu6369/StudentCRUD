package com.student.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@Document(collection = "student")
public class Student {
    private String id;
    private String name;
    private String email;
    private int age;
}
