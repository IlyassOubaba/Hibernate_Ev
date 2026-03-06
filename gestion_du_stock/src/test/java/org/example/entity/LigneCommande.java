package org.example.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class LigneCommande implements Serializable {

    @EmbeddedId
    private LigneCommandeId id;

    private int quantite;

    @ManyToOne
    @MapsId("commandeId")
    @JoinColumn(name = "commande_id")
    private Commande commande;

    @ManyToOne
    @MapsId("produitId")
    @JoinColumn(name = "produit_id")
    private Produit produit;

    public LigneCommande() {}

    public LigneCommande(Commande commande, Produit produit, int quantite) {
        this.commande = commande;
        this.produit = produit;
        this.quantite = quantite;
        this.id = new LigneCommandeId(commande.getId(), produit.getId());
    }

    // Getters et Setters
    public LigneCommandeId getId() { return id; }
    public void setId(LigneCommandeId id) { this.id = id; }

    public int getQuantite() { return quantite; }
    public void setQuantite(int quantite) { this.quantite = quantite; }

    public Commande getCommande() { return commande; }
    public void setCommande(Commande commande) { this.commande = commande; }

    public Produit getProduit() { return produit; }
    public void setProduit(Produit produit) { this.produit = produit; }
}