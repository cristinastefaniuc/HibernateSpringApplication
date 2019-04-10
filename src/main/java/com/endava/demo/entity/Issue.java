package com.endava.demo.entity;

public class Issue {
    private Fields fields;

    public Issue(Fields fields) {
        this.fields = fields;
    }

    public Issue() {
    }

    public Fields getFields() {
        return fields;
    }

    public void setFields(Fields fields) {
        this.fields = fields;
    }
}
