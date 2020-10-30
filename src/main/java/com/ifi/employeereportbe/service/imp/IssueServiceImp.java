package com.ifi.employeereportbe.service.imp;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ifi.employeereportbe.entity.Issue;
import com.ifi.employeereportbe.service.IssueService;
import com.ifi.employeereportbe.util.Constants;
import com.ifi.employeereportbe.util.RedmineAPIUtils;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class IssueServiceImp implements IssueService {
    @Override
    public List<Issue> getRedmineIssue(int sprint) {
        return RedmineAPIUtils.getAllIssue(sprint);
    }

    @Override
    public Map<String, Map> getRedmineIssue1(int sprint) {
        ObjectMapper mapper = new ObjectMapper();
        Map<String,Map> issuesResponse = new HashMap<>();
        int low, normal,high,urgent,immediate;
        int closed,newst,inprogress,resolved,feedback,rejected,cancelled;
        low = normal = high = urgent = immediate = closed = newst = inprogress = resolved = feedback = rejected = cancelled = 0;

        List<Issue> listIssues = null;
        try {
            listIssues = RedmineAPIUtils.getAllIssue(sprint);
        }catch (Exception e){
            e.printStackTrace();
        }
        Map<String,Integer> priorityIssue = new HashMap<>();
        Map<String,Integer> statusIssue = new HashMap<>();
        Map<String,Integer> noIssue = new HashMap<>();
        if(listIssues!=null){
            for(Issue i : listIssues){
                if(i.getTracker()!=null && i.getTracker().equals(Constants.RedmineIssue.BUG)){
                    if (i.getPriority()!=null) {
                        if (i.getPriority().equals(Constants.RedmineIssue.LOW)) {
                            low++;
                        }
                        else if (i.getPriority().equals(Constants.RedmineIssue.NORMAL)) {
                            normal++;
                        }
                        else if (i.getPriority().equals(Constants.RedmineIssue.HIGH)) {
                            high++;
                        }
                        else if (i.getPriority().equals(Constants.RedmineIssue.URGENT)) {
                            urgent++;
                        }
                        else if (i.getPriority().equals(Constants.RedmineIssue.IMMEDIATE)) {
                            immediate++;
                        }
                    }
                    if (i.getStatus()!=null) {
                        if (i.getStatus().equals(Constants.RedmineIssue.CLOSED))
                            closed++;
                        if (i.getStatus().equals(Constants.RedmineIssue.NEW))
                            newst++;
                        if (i.getStatus().equals(Constants.RedmineIssue.INPROGRESS))
                            inprogress++;
                        if (i.getStatus().equals(Constants.RedmineIssue.RESOLVED))
                            resolved++;
                        if (i.getStatus().equals(Constants.RedmineIssue.FEEDBACK))
                            feedback++;
                        if (i.getStatus().equals(Constants.RedmineIssue.REJECTED))
                            rejected++;
                        if (i.getStatus().equals(Constants.RedmineIssue.CANCELLED))
                            cancelled++;
                    }
                }
            }
            // set map priority
            priorityIssue.put(Constants.RedmineIssue.LOW, low);
            priorityIssue.put(Constants.RedmineIssue.NORMAL, normal);
            priorityIssue.put(Constants.RedmineIssue.HIGH, high);
            priorityIssue.put(Constants.RedmineIssue.URGENT, urgent);
            priorityIssue.put(Constants.RedmineIssue.IMMEDIATE, immediate);

            //set map status
            statusIssue.put(Constants.RedmineIssue.CLOSED, closed);
            statusIssue.put(Constants.RedmineIssue.NEW, newst);
            statusIssue.put(Constants.RedmineIssue.INPROGRESS, inprogress);
            statusIssue.put(Constants.RedmineIssue.RESOLVED, resolved);
            statusIssue.put(Constants.RedmineIssue.FEEDBACK, feedback);
            statusIssue.put(Constants.RedmineIssue.REJECTED, rejected);
            statusIssue.put(Constants.RedmineIssue.CANCELLED, cancelled);

            //set map response
            try {
                String priority = mapper.writeValueAsString(priorityIssue);
                String status = mapper.writeValueAsString(statusIssue);
                issuesResponse.put("ByPriority", priorityIssue);
                issuesResponse.put("ByStatus", statusIssue);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        }else{
            // set map not found issue
            noIssue.put(Constants.RedmineIssue.NOTFOUND,0);
            //set map response
            try {
                issuesResponse.put("NotFound", noIssue);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return issuesResponse;
    }


}
