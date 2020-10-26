package com.ifi.employeereportbe.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class IssueDTO {

    private String issueId;
    private String status;
    private String priority;
    private String tracker;
}
