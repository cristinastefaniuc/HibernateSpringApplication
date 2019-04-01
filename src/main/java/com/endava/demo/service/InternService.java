package com.endava.demo.service;

import com.endava.demo.entity.Intern;

import java.util.List;

public interface InternService {
    List<Intern> getAllInterns();
    void add(Intern intern);
    void remove(Integer id);
    Intern getInternById(Integer id);
    void update(Intern intern);
}
