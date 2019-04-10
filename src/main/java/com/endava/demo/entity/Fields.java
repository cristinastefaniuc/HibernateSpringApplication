package com.endava.demo.entity;

import java.util.List;

public class Fields {
    private Project project;
    private String summary;
    private IssueType issuetype;
    private List<String> labels;

    public Fields(Project project, String summary, IssueType issuetype, List<String> labels) {
        this.project = project;
        this.summary = summary;
        this.issuetype = issuetype;
        this.labels = labels;
    }

    public Fields() {
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public IssueType getIssuetype() {
        return issuetype;
    }

    public void setIssuetype(IssueType issuetype) {
        this.issuetype = issuetype;
    }

    public List<String> getLabels() {
        return labels;
    }

    public void setLabels(List<String> labels) {
        this.labels = labels;
    }
}
