package com.ifi.employeereportbe.util;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.ifi.employeereportbe.entity.Issue;
import com.ifi.employeereportbe.entity.Project;
import com.ifi.employeereportbe.entity.Version;

import java.util.ArrayList;
import java.util.List;

public class RedmineAPIUtils {

    private static final String baseUrl = "http://localhost:80/";
    private static final String username = "user";
    private static final String password = "bitnami1";
    private static RESTInvoker restInvoker;

    private static List<Project> projectList = new ArrayList<>();

    static {
        restInvoker = new RESTInvoker(baseUrl,username,password);
        projectList.add(new Project("1", "test-employee"));
        projectList.add(new Project("2", "test-employee"));
        projectList.add(new Project("3", "test-employee"));
    }

    public static boolean createIssue() throws Exception{
        Issue issue = new Issue();
        postJSONFromRedmine("issue.json",issue);
        return true;
    }

    public static List<Issue> getAllIssue(int sprint){
        projectList = getAllTagetVersion(projectList);
        List<Version> versionOfSprintList = new ArrayList<>();
        for (Project project : projectList) {
            List<Version> versionList = project.getVersionList();
            for (Version version : versionList) {
                if (version.getVersionName().contains(String.valueOf(sprint))){
                    versionOfSprintList.add(version);
                }
            }
        }
        List<Issue> issueList = getAllIssueByVersion(versionOfSprintList);
        return issueList;
    }

    private static List<Issue> getAllIssueByVersion(List<Version> versionList){
        List<Issue> issueList = new ArrayList<>();

        for (Version version : versionList) {
            String path = "issue.json?project_id=" + version.getProjectId();
            String js = getJSONFromRedmine(path);
            JsonObject jsonObject = new JsonParser().parse(js).getAsJsonObject();
            JsonArray issueArray = (JsonArray) jsonObject.get("issues");

            for (int i = 0; i < issueArray.size(); i++) {
                JsonObject issueObj = (JsonObject) issueArray.get(i);
                String tracker = JSonUtils.getChildOfJson(issueObj, "tracker", "name");
                String status = JSonUtils.getChildOfJson(issueObj, "status", "name");
                String priority = JSonUtils.getChildOfJson(issueObj, "priority", "name");
                String id = JSonUtils.getChildOfJson(issueObj, "id");
                Issue issue = new Issue();
                issue.setTracker(tracker);
                issue.setStatus(status);
                issue.setIssueId(id);
                issue.setPriority(priority);
                issue.setAssigned_to(JSonUtils.getChildOfJson(issueObj,"assigned_id", "name"));
                issueList.add(issue);
            }
        }
        return issueList;
    }

    private static List<Project> getAllTagetVersion(List<Project> projectList) {
        for (Project project: projectList) {
            String path = "projects/" + project.getProjectId() + "/version.json";
            String js = getJSONFromRedmine(path);
            JsonObject jsonObject = new JsonParser().parse(js).getAsJsonObject();
            JsonArray issueArray = (JsonArray) jsonObject.get("versions");
            List<Version> versionList = new ArrayList<>();
            for (int i = 0; i < issueArray.size(); i++) {
                JsonObject issue = (JsonObject) issueArray.get(i);
                String name = JSonUtils.getChildOfJson(issue, "name");
                String due_date = JSonUtils.getChildOfJson(issue, "due_date");
                String id = JSonUtils.getChildOfJson(issue, "id");
                Version version = new Version();
                version.setVersionName(name);
                version.setDueName(due_date);
                version.setProjectId(project.getProjectId());
                version.setVersionId(id);
                versionList.add(version);
            }
            project.setVersionList(versionList);
        }
        return projectList;
    }

    private static String getJSONFromRedmine(String path){
        return restInvoker.getDataFromSever(path);
    }
    private static String postJSONFromRedmine(String path, Object inputObj) throws Exception{
        return restInvoker.postDataToServer(path,inputObj);
    }
}
