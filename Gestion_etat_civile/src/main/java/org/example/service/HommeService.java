package org.example.service;

import org.example.dao.IDao;
import org.example.entity.*;
import org.example.util.HibernateUtil;
import org.hibernate.Session;

import java.util.Date;
import java.util.List;

public class HommeService implements IDao<Homme> {

    public void create(Homme h) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        s.save(h);
        s.getTransaction().commit();
        s.close();
    }
    public void update(Homme h) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        s.update(h);
        s.getTransaction().commit();
        s.close();
    }
    public void delete(Homme h) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        s.delete(h);
        s.getTransaction().commit();
        s.close();
    }
    public Homme findById(int id) {
            Session s = HibernateUtil.getSessionFactory().openSession();
            s.beginTransaction();
            Homme homme = (Homme) s.get(Homme.class, id);
            s.getTransaction().commit();
            s.close();
            return homme;
    }
    public List<Homme> getAll() {
        Session s = HibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        List<Homme> homme = (List<Homme>) s.createQuery("from Homme").list();
        s.getTransaction().commit();
        s.close();
        return homme;
    }

    public void afficherEpousesEntreDeuxDates(int idHomme, Date d1, Date d2) {
        Session s = HibernateUtil.getSessionFactory().openSession();

        List<Mariage> list = s.createQuery(
                        "from Mariage m where m.homme.id = :id and m.dateDebut between :d1 and :d2",
                        Mariage.class)
                .setParameter("id", idHomme)
                .setParameter("d1", d1)
                .setParameter("d2", d2)
                .getResultList();

        list.forEach(m ->
                System.out.println(m.getFemme().getNom() + " " + m.getFemme().getPrenom())
        );
        s.close();
    }
}
