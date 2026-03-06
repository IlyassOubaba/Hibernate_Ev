package org.example.service;

import org.example.dao.IDao;
import org.example.entity.*;
import org.example.util.HibernateUtil;
import org.hibernate.Session;

import java.util.List;

public class MariageService implements IDao<Mariage> {

    public void create(Mariage m) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        s.save(m);
        s.getTransaction().commit();
        s.close();
    }
    public void update(Mariage m) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        s.update(m);
        s.getTransaction().commit();
        s.close();
    }
    public void delete(Mariage m) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        s.delete(m);
        s.getTransaction().commit();
        s.close();
    }
    public Mariage findById(int id) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        Mariage mariage = (Mariage) s.get(Mariage.class, id);
        s.getTransaction().commit();
        s.close();
        return mariage;

    }
    public List<Mariage> getAll() {
        Session s = HibernateUtil.getSessionFactory().openSession();
        List<Mariage> mariages = (List<Mariage>) s.createQuery("from Mariage").list();
        s.getTransaction().commit();
        s.close();
        return mariages;
    }

}
