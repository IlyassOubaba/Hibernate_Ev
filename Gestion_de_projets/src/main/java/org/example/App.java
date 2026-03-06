package org.example;

import org.example.entity.*;
import org.example.dao.*;
import org.example.service.*;

import java.util.Date;

public class App {

    public static void main(String[] args) {

        EmployeService es = new EmployeService();
        ProjetService ps = new ProjetService();
        TacheService ts = new TacheService();
        EmployeTacheService ets = new EmployeTacheService();


        Employe e1 = new Employe();
        e1.setNom("Yassin");
        e1.setPrenom("hddo");
        e1.setTelephone("0612345678");

        Employe e2 = new Employe();
        e2.setNom("Ilyass");
        e2.setPrenom("oubaba");
        e2.setTelephone("0624354668");

        es.save(e1);
        es.save(e2);


        Projet p1 = new Projet();
        p1.setNom("Projet AI");
        p1.setDateDebut(new Date());
        p1.setDateFin(new Date());

        Projet p2 = new Projet();
        p1.setNom("Projet ML");
        p1.setDateDebut(new Date());
        p1.setDateFin(new Date());

        ps.save(p1);
        ps.save(p2);

        Tache t1 = new Tache();
         t1.setNom("analuse");
         t1.setDateDebut(new Date());
         t1.setDateFin(new Date());
         t1.setPrix(800.120);
         t1.setProjet(p1);

        Tache t2 = new Tache();
        t2.setNom("Développement");
        t2.setDateDebut(new Date());
        t2.setDateFin(new Date());
        t2.setPrix(1500.234);
        t2.setProjet(p1);

        Tache t3 = new Tache();
        t2.setNom("Conception");
        t2.setDateDebut(new Date());
        t2.setDateFin(new Date());
        t2.setPrix(1956.120);
        t2.setProjet(p2);

        ts.save(t1);
        ts.save(t2);
        ts.save(t3);


        EmployeTache et1 = new EmployeTache(new Date(), new Date(), e2, t1);
        EmployeTache et2 = new EmployeTache(new Date(), new Date(), e2, t2);

        ets.save(et1);
        ets.save(et2);



        System.out.println("\n Tâches réalisées par l'employé Ilyass :");
        es.tachesRealiseesParEmploye(e2.getId()).forEach(t -> System.out.println("- " + t.getNom()));

        System.out.println("\n Projets gérés par Yassin : ");
        es.projetsGeresParEmploye(e1.getId()).forEach(p -> System.out.println("- " + p.getNom()));

        System.out.println("\n Tâches planifiées du projet :");
        ps.tachesPlanifiés(p1.getId()).forEach(t -> System.out.println("- " + t.getNom()));

        System.out.println("\n Tâches réalisées avec dates réelles :");
        ps.tachesRealiseesAvecDates(p1.getId()).forEach(obj -> System.out.println(
                        "- " + obj[0] + " | Debut reelle : " + obj[1] + " | Fin reelle : " + obj[2]));

        System.out.println("\n Tâches avec prix > 1000 DH :");
        ts.tachesPrixSuperieurA1000().forEach(t -> System.out.println("- " + t.getNom() + " : " + t.getPrix() + " DH"));


    }
}