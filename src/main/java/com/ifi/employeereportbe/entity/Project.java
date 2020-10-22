package com.ifi.employeereportbe.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "projects")
@Data
public class Project {

//    @Transient
//    public static final String SEQUENCE_NAME = "users_sequence";

    @Id
    private String projectId;

    @Indexed
    private String projectName;

    @Indexed
    private List<Version> versionList;

    @Indexed
    private List<Issue> issueList;
}
