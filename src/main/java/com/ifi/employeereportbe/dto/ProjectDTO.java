package com.ifi.employeereportbe.dto;

import com.ifi.employeereportbe.entity.Issue;
import com.ifi.employeereportbe.entity.Version;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ProjectDTO {

    private String projectId;
    private String projectName;
    private List<Version> versionList;
    private List<Issue> issueList;
}
