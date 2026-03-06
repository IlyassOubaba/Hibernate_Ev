package org.example.entity;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class LigneCommandeId implements Serializable {
    private int commandeId;
    private int produitId;

    public LigneCommandeId() {}

    public LigneCommandeId(int commandeId, int produitId) {
        this.commandeId = commandeId;
        this.produitId = produitId;
    }

    public int getCommandeId() { return commandeId; }
    public void setCommandeId(int commandeId) { this.commandeId = commandeId; }

    public int getProduitId() { return produitId; }
    public void setProduitId(int produitId) { this.produitId = produitId; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LigneCommandeId that = (LigneCommandeId) o;
        return commandeId == that.commandeId && produitId == that.produitId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(commandeId, produitId);
    }
}