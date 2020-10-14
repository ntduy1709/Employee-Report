package com.ifi.employeereportbe.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.Date;

@Document(collection = "employees")
@Data
public class Employee {

    @Id
    private String id;

    private String name;

    private Date birthDay;

}
