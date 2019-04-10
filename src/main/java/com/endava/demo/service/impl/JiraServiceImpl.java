package com.endava.demo.service.impl;

import com.endava.demo.entity.Issue;
import com.endava.demo.service.JiraService;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class JiraServiceImpl implements JiraService {

    RestTemplate restTemplate = new RestTemplate();

    public HttpHeaders setHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add("Cookie", getCookie().get(0));
        headers.add("Cookie", getCookie().get(1));

        return headers;
    }

    @Override
    public List<String> getCookie() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        Map<String, String> body = new HashMap<>();
        body.put("username", "username");
        body.put("password", "password");

        HttpEntity request = new HttpEntity<>(body,headers);
        HttpEntity<Object> obj = restTemplate.exchange("https://uatjira.endava.com/rest/auth/1/session",
                HttpMethod.POST, request, Object.class);

        HttpHeaders getHeader = obj.getHeaders();
        List<String> set_cookie = getHeader.get(headers.SET_COOKIE);

        return set_cookie;
    }

    @Override
    public ResponseEntity<?> getIssue(String idOrKey) {
        HttpEntity request = new HttpEntity<>(null, setHeaders());

        Object obj = restTemplate.exchange("https://uatjira.endava.com/rest/api/2/issue/" + idOrKey,
                HttpMethod.GET, request, Object.class);

        return new ResponseEntity<>(obj, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> searchIssueByAssigneeOrByDate(String assignee, String date) {
        HttpEntity request = new HttpEntity<>(null, setHeaders());

        //when searching by date, put it in " ",
        // when you don't want to search by date put 0,
        // when you don't want to search by assignee put Empty,
        Object obj = restTemplate.exchange("https://uatjira.endava.com/rest/api/2/search?jql=assignee in (" + assignee + ") AND createdDate>=" + date,
                HttpMethod.GET, request, Object.class);

        return new ResponseEntity<>(obj, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> createIssue(Issue issue) {
        HttpEntity request = new HttpEntity<>(issue, setHeaders());

        Object obj = restTemplate.postForObject("https://uatjira.endava.com/rest/api/2/issue",
                request, Object.class);
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> updateIssue(String idOrKey, Issue issue) {
        HttpEntity request = new HttpEntity<>(issue, setHeaders());

        Object obj = restTemplate.exchange("https://uatjira.endava.com/rest/api/2/issue/" + idOrKey,
                HttpMethod.PUT, request, Object.class);
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }
}


