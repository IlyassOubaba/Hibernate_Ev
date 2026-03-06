package org.example.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "employe")
public class Employe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nom;
    private String prenom;
    private String telephone;

    @OneToMany(mappedBy = "employe", cascade = CascadeType.ALL)
    private List<Projet> projets;

    @OneToMany(mappedBy = "employe", cascade = CascadeType.ALL)
    private List<EmployeTache> employeTache;

    public Employe() {}

    public Employe(String nom, String prenom, String telephone, List<Projet> projets, List<EmployeTache> employeTache) {
        this.nom = nom;
        this.prenom = prenom;
        this.telephone = telephone;
        this.projets = projets;
        this.employeTache = employeTache;
    }

    public Employe(String nom, String prenom, String telephone) {
        this.nom = nom;
        this.prenom = prenom;
        this.telephone = telephone;
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

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public List<Projet> getProjets() {
        return projets;
    }

    public void setProjets(List<Projet> projets) {
        this.projets = projets;
    }

    public List<EmployeTache> getEmployeTache() {
        return employeTache;
    }

    public void setEmployeTache(List<EmployeTache> employeTache) {
        this.employeTache = employeTache;
    }


}
