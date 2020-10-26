package com.ifi.employeereportbe.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Issue")
@Data
public class Issue {

    @Id
    private String issueId;

    @Indexed
    private String status;

    @Indexed
    private String priority;

    @Indexed
    private String tracker;

    @Indexed
    private String assigned_to;

}
