package com.ifi.employeereportbe.service;

import com.ifi.employeereportbe.entity.Issue;

import java.util.List;

public interface IssueService {

    List<Issue> getRedminIssue(int sprint);
}
