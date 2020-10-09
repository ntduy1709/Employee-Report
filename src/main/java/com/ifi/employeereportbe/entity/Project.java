package com.ifi.employeereportbe.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "project")
@Data
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "progress")
    private byte progress;
}
