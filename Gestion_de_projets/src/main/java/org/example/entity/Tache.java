package org.example.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@NamedQuery(
               name = "Tache.prixSuperieurA1000",
               query = "from Tache t where t.prix > 1000"
)
@Table(name = "tache")
public class Tache {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nom;
    private Date dateDebut;
    private Date dateFin;
    private Double prix;

    @ManyToOne
    @JoinColumn(name = "projet_id")
    private Projet projet;

    @OneToMany(mappedBy = "tache", cascade = CascadeType.ALL)
    private List<EmployeTache> employeTaches;

    public Tache() {
    }

    public Tache(String nom, Date dateDebut, Double prix, Date dateFin, Projet projet, List<EmployeTache> employeTaches) {
        this.nom = nom;
        this.dateDebut = dateDebut;
        this.prix = prix;
        this.dateFin = dateFin;
        this.projet = projet;
        this.employeTaches = employeTaches;
    }

    public Tache(String nom, Date dateDebut, Date dateFin, Double prix) {
        this.nom = nom;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.prix = prix;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Double getPrix() {
        return prix;
    }

    public void setPrix(Double prix) {
        this.prix = prix;
    }

    public Projet getProjet() {
        return projet;
    }

    public void setProjet(Projet projet) {
        this.projet = projet;
    }

    public List<EmployeTache> getEmployeTache() {
        return employeTaches;
    }

    public void setEmployeTache(List<EmployeTache> employeTache) {
        this.employeTaches = employeTaches;
    }
}
