package org.example.service;

import org.example.dao.IDao;
import org.example.entity.*;
import org.example.util.HibernateUtil;
import org.hibernate.Session;

import javax.persistence.Query;
import java.util.Date;
import java.util.List;

public class FemmeService implements IDao<Femme> {

    public void create(Femme f) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        s.save(f);
        s.getTransaction().commit();
        s.close();
    }
    public void update(Femme f) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        s.update(f);
        s.getTransaction().commit();
        s.close();
    }
    public void delete(Femme f) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        s.delete(f);
        s.getTransaction().commit();
        s.close();

    }
    public Femme findById(int id) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        Femme femme = (Femme) s.get(Femme.class, id);
        s.getTransaction().commit();
        s.close();
        return femme;
    }
    public List<Femme> getAll() {
        Session s = HibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        List<Femme> femme = (List<Femme>) s.createQuery("from Femme").list();
        s.getTransaction().commit();
        s.close();
        return femme;
    }

    public Long nbrEnfants(int id, Date d1, Date d2) {

        Session session = HibernateUtil.getSessionFactory().openSession();

        Query q = session.createQuery(
                "select sum(m.nbrEnfant) from Mariage m " +
                        "where m.femme.id = :id " +
                        "and m.dateDebut between :d1 and :d2"
        );

        q.setParameter("id", id);
        q.setParameter("d1", d1);
        q.setParameter("d2", d2);

        Long result = (Long) q.getSingleResult();

        session.close();

        return result;
    }

    public void femmesmarieDeuxFois() {
        Session s = HibernateUtil.getSessionFactory().openSession();
        s.createQuery("select f from Femme f where size(f.mariages) >= 2", Femme.class).getResultList()
                .forEach(f -> System.out.println(f.getNom()));

        s.close();
    }
}
