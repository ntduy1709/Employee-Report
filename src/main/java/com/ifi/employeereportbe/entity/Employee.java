package com.ifi.employeereportbe.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "employee")
@Data
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "DoB")
    private Date birthDay;

}
