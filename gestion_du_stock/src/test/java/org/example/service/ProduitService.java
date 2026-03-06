package org.example.service;

import org.example.entity.*;
import org.example.entity.Categorie;
import org.example.dao.IDao;
import org.example.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.Date;
import java.util.List;

public class ProduitService implements IDao<Produit> {


    public void save(Produit o) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(o);
            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();

        }
    }

    @Override
    public void update(Produit o) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.update(o);
            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();

        }
    }


    public void delete(Produit o) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.delete(o);
            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();

        }
    }

    public Produit findById(int id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Produit.class, id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Produit> findAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Produit> query = session.createQuery("from Produit", Produit.class);
            return query.list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // afficher la liste des produits par catégorie
    public List<Produit> getProduitsByCategorie(Categorie categorie) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Produit> query = session.createQuery(
                    "from Produit p where p.categorie = :categorie", Produit.class);
            query.setParameter("categorie", categorie);
            return query.list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // afficher les produits commandés entre deux dates
    public List<Produit> getProduitsCommandesEntreDates(Date dateDebut, Date dateFin) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Produit> query = session.createQuery(
                    "select distinct p from Produit p join p.ligneCommandes lc " +
                            "where lc.commande.date between :dateDebut and :dateFin", Produit.class);
            query.setParameter("dateDebut", dateDebut);
            query.setParameter("dateFin", dateFin);
            return query.list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // afficher les produits commandés dans une commande donnée
    public List<Produit> getProduitsByCommande(int commandeId) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Produit> query = session.createQuery(
                    "select p from Produit p join p.ligneCommandes lc " +
                            "where lc.commande.id = :commandeId", Produit.class);
            query.setParameter("commandeId", commandeId);
            return query.list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}