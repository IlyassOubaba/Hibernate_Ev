package org.example.service;

import org.example.dao.IDao;
import org.example.entity.Tache;
import org.example.util.HibernateUtil;
import org.hibernate.Session;

import java.util.List;

public class TacheService implements IDao<Tache> {

    public void save(Tache tache){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(tache);
        session.getTransaction().commit();
        session.close();
    }
    public void update(Tache tache){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(tache);
        session.getTransaction().commit();
        session.close();

    }
    public void delete(Tache tache){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(tache);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public Tache findById(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Tache tache = (Tache) session.get(Tache.class, id);
        session.getTransaction().commit();
        session.close();
        return tache;

    }

    @Override
    public List<Tache> findAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        List<Tache> tache = (List<Tache>) session.createQuery("from Tache").list();
        session.getTransaction().commit();
        session.close();
        return tache;
    }

    public List<Tache> tachesPrixSuperieurA1000 () {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        List<Tache> tach = (List<Tache>) session.createNamedQuery("Tache.prixSuperieurA1000",Tache.class).getResultList();
        session.getTransaction().commit();
        session.close();
        return tach ;
    }




}
