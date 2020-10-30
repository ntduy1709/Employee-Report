package com.ifi.employeereportbe.service;

import com.ifi.employeereportbe.entity.Issue;

import java.util.List;
import java.util.Map;

public interface IssueService {

    List<Issue> getRedmineIssue(int sprint);

    Map<String, Map> getRedmineIssue1(int sprint);
}
