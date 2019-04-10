package com.endava.demo.service;

import com.endava.demo.entity.Issue;
import org.springframework.http.ResponseEntity;

import java.util.Date;
import java.util.List;

public interface JiraService {

    ResponseEntity<?> createIssue(Issue issue);
    ResponseEntity<?> updateIssue(String idOrKey, Issue issue);
    List<String> getCookie();
    ResponseEntity<?> getIssue(String idOrKey);
    ResponseEntity<?> searchIssueByAssigneeOrByDate(String assignee, String date);
}
