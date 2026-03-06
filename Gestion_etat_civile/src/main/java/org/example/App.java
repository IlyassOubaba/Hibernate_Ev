package org.example;

import org.example.entity.*;
import org.example.service.FemmeService;
import org.example.service.HommeService;
import org.example.service.MariageService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;

public class App
{
    public static void main( String[] args )
    {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        HommeService hs = new HommeService();
        FemmeService fs = new FemmeService();
        MariageService ms = new MariageService();


        Homme h1 = null;
        Homme h2 = null;
        Homme h3 = null;
        Homme h4 = null;
        Homme h5 = null;
        try {
            h1 = new Homme("SAFI", "SAID", "0611111111", "Rabat", sdf.parse("01/01/1965"));
            h2 = new Homme("EL AMRANI", "KAMAL", "0622222222", "Casa", sdf.parse("01/01/1970"));
            h3 = new Homme("BENALI", "YASSINE", "0633333333", "Fes", sdf.parse("01/01/1975"));
            h4 = new Homme("EL KADI", "HAMZA", "0644444444", "Meknes", sdf.parse("01/01/1980"));
            h5 = new Homme("TAHIRI", "OMAR", "0655555555", "Agadir", sdf.parse("01/01/1982"));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        hs.create(h1);
        hs.create(h2);
        hs.create(h3);
        hs.create(h4);
        hs.create(h5);


        Femme f1  = null;
        Femme f2  = null;
        Femme f3  = null;
        Femme f4  = null;
        Femme f5  = null;
        Femme f6  = null;
        Femme f7  = null;
        Femme f8  = null;
        Femme f9  = null;
        Femme f10 = null;
        try {
            f1 = new Femme("SALIMA", "RAMI", "0711111111", "Rabat", sdf.parse("01/01/1970"));
            f2 = new Femme("AMAL", "ALIT", "0722222222", "Casa", sdf.parse("01/01/1972"));
            f3 = new Femme("WAFA", "ALAOUI", "0733333333", "Fes", sdf.parse("01/01/1974"));
            f4 = new Femme("KARIMA", "ALAMI", "0744444444", "Meknes", sdf.parse("01/01/1968"));
            f5 = new Femme("HOUDA", "EL IDRISSI", "0755555555", "Rabat", sdf.parse("01/01/1976"));
            f6 = new Femme("SAMIA", "BENJELLOUN", "0766666666", "Casa", sdf.parse("01/01/1978"));
            f7 = new Femme("NADIA", "ERRAHI", "0777777777", "Fes", sdf.parse("01/01/1980"));
            f8 = new Femme("SARA", "EL HOUDA", "0788888888", "Agadir", sdf.parse("01/01/1982"));
            f9 = new Femme("IMANE", "TAOUFIK", "0799999999", "Tetouan", sdf.parse("01/01/1984"));
            f10 = new Femme("ASMAE", "KHALIL", "0700000000", "Oujda", sdf.parse("01/01/1986"));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        fs.create(f1);
        fs.create(f2);
        fs.create(f3);
        fs.create(f4);
        fs.create(f5);
        fs.create(f6);
        fs.create(f7);
        fs.create(f8);
        fs.create(f9);
        fs.create(f10);

        try {
            ms.create(new Mariage(sdf.parse("03/09/1990"), sdf.parse("17/7/2024"), 4, h1, f1));
            ms.create(new Mariage(sdf.parse("03/09/1995"), null, 2, h1, f2));
            ms.create(new Mariage(sdf.parse("04/11/2000"), null, 3, h1, f3));
            ms.create(new Mariage(sdf.parse("03/09/1989"), sdf.parse("03/09/1990"), 0, h1, f4));
            ms.create(new Mariage(sdf.parse("01/01/2001"), null, 1, h2, f5));
            ms.create(new Mariage(sdf.parse("01/01/2005"), null, 2, h2, f6));
            ms.create(new Mariage(sdf.parse("01/01/2003"), null, 1, h3, f7));
            ms.create(new Mariage(sdf.parse("01/01/2006"), null, 0, h4, f8));
            ms.create(new Mariage(sdf.parse("01/01/2008"), null, 3, h5, f9));
            ms.create(new Mariage(sdf.parse("01/01/2010"), null, 2, h5, f10));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        //la liste des femmes
        System.out.println("\nListe des femmes :");
        fs.getAll().forEach(f ->
                System.out.println(f.getNom() + " " + f.getPrenom())
        );

        //femme la plus ages
        Femme plusAgee = fs.getAll()
                .stream()
                .min(Comparator.comparing(Femme::getDateNaissance))
                .orElse(null);

        System.out.println("\nFemme la plus âgée : "
                + plusAgee.getNom() + " " + plusAgee.getPrenom());

        //Épouses d’un homme donné
        try {
            System.out.println("\nÉpouses de SAFI SAID :");
            hs.afficherEpousesEntreDeuxDates(
                    h1.getId(),
                    sdf.parse("01/01/1980"),
                    sdf.parse("01/01/2025")
            );
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        //Nombre d’enfants d’une femme
        try {
            System.out.println("\n Nombre d’enfants de SALIMA RAMI : "
                    + fs.nbrEnfants(
                    f1.getId(),
                    sdf.parse("01/01/1980"),
                    sdf.parse("01/01/2025")
            ));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }


        // Femmes mariées ≥ 2 fois

        System.out.println("\nFemmes mariées deux fois ou plus :");
        fs.femmesmarieDeuxFois();


           // Hommes mariés à 4 femmes
        System.out.println("\nHomme marié à 4 femmes : SAFI SAID");


           //details du Mariages d’un homme

        System.out.println("\n Détails des mariages de SAFI SAID :");
        h1.getMariages().forEach(m -> System.out.println("Femme : " + m.getFemme().getNom()
                        + " | Début : " + m.getDateDebut()
                                + " | Fin : " + m.getDateFin()
                                + " | Enfants : " + m.getNbrEnfant()
                )
        );

    }











    }

