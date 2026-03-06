package org.example;

import org.example.entity.*;
import org.example.service.*;
import org.example.util.HibernateUtil;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class AppTest {

    public static void main(String[] args) {
        try {
            // Création des services
            CategorieService categorieService = new CategorieService();
            ProduitService produitService = new ProduitService();
            CommandeService commandeService = new CommandeService();
            LigneCommandeService ligneCommandeService = new LigneCommandeService();

            // Création des catégories
            Categorie cat1 = new Categorie("PC", "Ordinateurs");
            Categorie cat2 = new Categorie("IMP", "Imprimantes");
            categorieService.save(cat1);
            categorieService.save(cat2);

            // Création des produits
            Produit p1 = new Produit("PC1", 5500, cat1);
            Produit p2 = new Produit("PC02", 7320, cat1);
            Produit p3 = new Produit("IMP01", 2341, cat2);
            produitService.save(p1);
            produitService.save(p2);
            produitService.save(p3);

            // Création des commandes
            Commande cmd1 = new Commande(new Date());
            Commande cmd2 = new Commande(new Date());
            commandeService.save(cmd1);
            commandeService.save(cmd2);

            // Création des lignes de commande
            LigneCommande lc1 = new LigneCommande(cmd1, p1, 2);
            LigneCommande lc2 = new LigneCommande(cmd1, p2, 1);
            LigneCommande lc3 = new LigneCommande(cmd2, p3, 3);
            ligneCommandeService.save(lc1);
            ligneCommandeService.save(lc2);
            ligneCommandeService.save(lc3);

            // Test des méthodes spécifiques
            System.out.println("---Produits par catégorie ---");
            List<Produit> produitsCat1 = produitService.getProduitsByCategorie(cat1);
            for (Produit p : produitsCat1) {
                System.out.println(p.getReference() + " - " + p.getPrix());
            }

            System.out.println("\n--- Produits commandés entre deux dates ---");
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
            Date debut = sdf.parse("2026-05-04");
            Date fin = new Date();
            List<Produit> produitsEntreDates = produitService.getProduitsCommandesEntreDates(debut, fin);
            for (Produit p : produitsEntreDates) {
                System.out.println(p.getReference());
            }

            System.out.println("\n--- Produits d'une commande spécifique ---");
            List<Produit> produitsCommande = produitService.getProduitsByCommande(cmd1.getId());
            for (Produit p : produitsCommande) {
                System.out.println(p.getReference());
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            HibernateUtil.shutdown();
        }
    }
}