package com.endava.demo.controller;

import com.endava.demo.entity.Issue;
import com.endava.demo.service.JiraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Date;

@RestController
public class JiraController {

    @Autowired
    private JiraService jiraService;

    @PostMapping("/createIssue")
    public ResponseEntity<?> createIssue(@RequestBody Issue issue) {
        return jiraService.createIssue(issue);
    }

    @GetMapping(value = "/getIssue/{idOrKey}")
    public ResponseEntity<?> getIssue(@PathVariable String idOrKey) {
        return jiraService.getIssue(idOrKey);
    }

    @PutMapping(value = "/updateIssue/{idOrKey}")
    public ResponseEntity<?> updateIssue(@PathVariable String idOrKey, @RequestBody Issue issue ) {
        return jiraService.updateIssue(idOrKey, issue);
    }

    @GetMapping(value = "/searchIssue/{assignee}/{date}")
    public ResponseEntity<?> searchIssue(@PathVariable("assignee") String assignee, @PathVariable("date") String date) {
        return jiraService.searchIssueByAssigneeOrByDate(assignee, date);
    }

}
