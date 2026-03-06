package org.example.service;

import org.example.dao.IDao;
import org.example.entity.Employe;
import org.example.entity.Projet;
import org.example.entity.Tache;
import org.example.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import java.util.List;

public class EmployeService implements IDao<Employe> {

    public void save(Employe employe){

            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(employe);
            session.getTransaction().commit();
            session.close();

    }
    public void update(Employe employe){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(employe);
        session.getTransaction().commit();
        session.close();

    }
    public void delete(Employe employe){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(employe);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public Employe findById(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Employe employe = (Employe) session.get(Employe.class, id);
        session.getTransaction().commit();
        session.close();
        return employe;

    }

    @Override
    public List<Employe> findAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        List<Employe> employe = (List<Employe>) session.createQuery("from Employe").list();
        session.getTransaction().commit();
        session.close();
        return employe;
    }

    public List<Projet> projetsGeresParEmploye(int idEmploye) {

        Session session = HibernateUtil.getSessionFactory().openSession();

        List<Projet> projets = session.createQuery(" from Projet p where p.employe.id = :id ", Projet.class).setParameter("id", idEmploye).list();
        session.close();
        return projets;
    }


    public List<Tache> tachesRealiseesParEmploye(int idEmploye) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Tache> taches = session.createQuery("select et.tache from EmployeTache et where et.employe.id = :id and et.dateDebutReelle is not null and et.dateFinReelle is not null ", Tache.class).setParameter("id", idEmploye).list();
        session.close();
        return taches;
    }
}
