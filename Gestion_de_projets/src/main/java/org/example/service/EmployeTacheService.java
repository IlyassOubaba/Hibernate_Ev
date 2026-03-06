package org.example.service;

import org.example.dao.IDao;
import org.example.entity.Employe;
import org.example.entity.EmployeTache;
import org.example.util.HibernateUtil;
import org.hibernate.Session;

import java.util.List;

public class EmployeTacheService implements IDao<EmployeTache> {

    public void save(EmployeTache employeTache){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(employeTache);
        session.getTransaction().commit();
        session.close();
    }
    public void update(EmployeTache employeTache){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(employeTache);
        session.getTransaction().commit();
        session.close();

    }
    public void delete(EmployeTache employeTache){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(employeTache);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public EmployeTache findById(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        EmployeTache employeTache = (EmployeTache) session.get(EmployeTache.class, id);
        session.getTransaction().commit();
        session.close();
        return employeTache;

    }

    @Override
    public List<EmployeTache> findAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        List<EmployeTache> employeTache = (List<EmployeTache>) session.createQuery("from EmployeTache").list();
        session.getTransaction().commit();
        session.close();
        return employeTache;
    }


}
