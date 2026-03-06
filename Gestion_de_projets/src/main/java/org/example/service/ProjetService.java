package org.example.service;

import org.example.dao.IDao;
import org.example.entity.Projet;
import org.example.entity.Tache;
import org.example.util.HibernateUtil;
import org.hibernate.Session;

import java.util.List;

public class ProjetService implements IDao<Projet> {

    public void save(Projet projet){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(projet);
        session.getTransaction().commit();
        session.close();
    }
    public void update(Projet projet){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(projet);
        session.getTransaction().commit();
        session.close();

    }
    public void delete(Projet projet){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(projet);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public Projet findById(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Projet projet = (Projet) session.get(Projet.class, id);
        session.getTransaction().commit();
        session.close();
        return projet;

    }

    @Override
    public List<Projet> findAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        List<Projet> projet = (List<Projet>) session.createQuery("FROM Projet").list();
        session.getTransaction().commit();
        session.close();
        return projet;
    }

    public List<Tache> tachesPlanifiés (int idProjet){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        List<Tache> taches = (List<Tache>) session.createQuery("select t from Tache t where t.projet.id = :id").setParameter("id", idProjet).list();
        session.getTransaction().commit();
        session.close();
        return taches;
    }
    public List<Object[]> tachesRealiseesAvecDates(int idProjet) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Object[]> result = session.createQuery("select et.tache.nom, et.dateDebutReelle, et.dateFinReelle from EmployeTache et where et.tache.projet.id = :id and et.dateDebutReelle is not null and et.dateFinReelle is not null ").setParameter("id", idProjet).list();
        session.close();
        return result;
    }


}
