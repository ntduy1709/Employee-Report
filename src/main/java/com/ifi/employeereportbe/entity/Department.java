package com.ifi.employeereportbe.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "department")
@Data
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;
}
