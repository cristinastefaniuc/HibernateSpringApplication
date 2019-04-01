package com.endava.demo.dao.impl;

import com.endava.demo.dao.InternDAO;
import com.endava.demo.entity.Intern;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class InternDAOImpl implements InternDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override

    public List<Intern> findAll() {
        return entityManager.createQuery("SELECT i FROM Intern i", Intern.class)
                .getResultList();
    }

    @Override
    @Transactional
    public void save(Intern intern) {
        entityManager.persist(intern);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        Intern intern = entityManager.find(Intern.class, id);
        entityManager.remove(intern);
    }

    @Override
    public Intern getInternById(Integer id) {
        return entityManager.find(Intern.class, id);
    }

    @Override
    @Transactional
    public void update(Intern intern) {
        entityManager.merge(intern);
    }
}
