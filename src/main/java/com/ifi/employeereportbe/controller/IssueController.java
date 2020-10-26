package com.ifi.employeereportbe.controller;

import com.ifi.employeereportbe.entity.Issue;
import com.ifi.employeereportbe.service.imp.IssueServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/redmine-issue")
public class IssueController {

    @Autowired
    private IssueServiceImp issueServiceImp;

    @GetMapping
    @ResponseBody
    public List<Issue> getRedminIssue(@RequestParam int sprint){
        return issueServiceImp.getRedminIssue(sprint);
    }
}
