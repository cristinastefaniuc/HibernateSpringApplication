package com.endava.demo.dao;

import com.endava.demo.entity.Intern;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

public interface InternDAO {
    List<Intern> findAll();
    void save(Intern intern);
    void delete(Integer id);
    Intern getInternById(Integer id);
    void update(Intern intern);
}
