package com.endava.demo.entity;


public class IssueType {
    private String name;

    public IssueType(String name) {
        this.name = name;
    }

    public IssueType() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
