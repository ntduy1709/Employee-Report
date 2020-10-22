package com.ifi.employeereportbe.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Version")
public class Version {

    @Id
    private String versionId;

    @Indexed
    private String projectId;

    @Indexed
    private String versionName;

    @Indexed
    private String dueName;
}
