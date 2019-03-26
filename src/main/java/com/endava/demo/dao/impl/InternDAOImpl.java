package com.endava.demo.dao.impl;

import com.endava.demo.dao.InternDAO;
import com.endava.demo.entity.Intern;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class InternDAOImpl implements InternDAO {

    private static Session currentSession;

    public static SessionFactory buildSessionFactory() {
        return new Configuration().addAnnotatedClass(Intern.class).buildSessionFactory();
    }

    public static Session openSession() {
        return currentSession = buildSessionFactory().openSession();
    }

    public static Transaction beginTransaction() {
        return currentSession.beginTransaction();
    }

    public static void commitTransaction() {
        beginTransaction().commit();
    }

    @Override
    public List<Intern> findAll() {
        return openSession().createQuery("SELECT i FROM Intern i", Intern.class)
                .getResultList();
    }

    @Override
    public void save(Intern intern) {
        openSession().persist(intern);
        commitTransaction();
        currentSession.close();
    }

    @Override
    public void delete(int id) {
        Intern intern = currentSession.get(Intern.class, id);
        openSession().delete(intern);
        commitTransaction();
        currentSession.close();
    }

    @Override
    public Intern getInternById(int id) {
        return currentSession.get(Intern.class, id);
    }

    @Override
    public void update(Intern intern) {
        openSession().saveOrUpdate(intern);
        commitTransaction();
        currentSession.close();
    }
}
