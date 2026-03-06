package org.example.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Femme extends Personne{

        @OneToMany(mappedBy = "femme")
        private List<Mariage> mariages =  new ArrayList<>();

    public Femme(String nom, String prenom, String telephone, String adress, Date dateNaissance) {
        super(nom, prenom, telephone, adress, dateNaissance);
    }


    public List<Mariage> getMariages() {
            return mariages;
        }

    public Femme() {
    }

    public Femme(String nom, String prenom, String telephone, String adresse, Date dateNaissance, List<Mariage> mariages) {
        super(nom, prenom, telephone, adresse, dateNaissance);
        this.mariages = mariages;
    }

    public void setMariages(List<Mariage> mariages) {
        this.mariages = mariages;
    }
}
