package com.ifi.employeereportbe.controller;

import com.ifi.employeereportbe.entity.Issue;
import com.ifi.employeereportbe.service.imp.IssueServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/redmine-issue")// prefix_url
public class IssueController {

    @Autowired
    private IssueServiceImp issueServiceImp;

    @GetMapping()
    @ResponseBody
    public List<Issue> getRedmineIssue(@RequestParam(value = "sprint") int sprint){
        return issueServiceImp.getRedmineIssue(sprint);
    }

    @GetMapping(value = "/getAllIssues", produces = MediaType.APPLICATION_JSON_VALUE + ";charset=utf-8")
    @ResponseBody
    public Map<String, Map> getRedmineIssue1(@RequestParam int sprint){
        return issueServiceImp.getRedmineIssue1(sprint);
    }
}
