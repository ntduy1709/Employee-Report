package com.ifi.employeereportbe.service.imp;

import com.ifi.employeereportbe.entity.Issue;
import com.ifi.employeereportbe.service.IssueService;
import com.ifi.employeereportbe.util.RedminAPIUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IssueServiceImp implements IssueService {
    @Override
    public List<Issue> getRedminIssue(int sprint) {
        return RedminAPIUtils.getAllIssue(sprint);
    }
}
