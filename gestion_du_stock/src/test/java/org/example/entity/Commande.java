package org.example.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Commande {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Temporal(TemporalType.DATE)
    private Date date;

    @OneToMany(mappedBy = "commande", cascade = CascadeType.ALL)
    private List<LigneCommande> ligneCommandes;

    public Commande() {}

    public Commande(Date date) {
        this.date = date;
    }

    // Getters et Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public Date getDate() { return date; }
    public void setDate(Date date) { this.date = date; }

    public List<LigneCommande> getLigneCommandes() { return ligneCommandes; }
    public void setLigneCommandes(List<LigneCommande> ligneCommandes) { this.ligneCommandes = ligneCommandes; }
}