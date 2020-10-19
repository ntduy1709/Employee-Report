package com.ifi.employeereportbe.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "departments")
@Data
public class Department {

    @Transient
    public static final String SEQUENCE_NAME = "departments_sequence";

    @Id
    private String id;

    private String name;
}
