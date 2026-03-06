package org.example.entity;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Entity
public class Homme extends Personne{


        @OneToMany(mappedBy = "homme")
        private List<Mariage> mariages = new ArrayList<>();

        public List<Mariage> getMariages() {
            return mariages;
        }

    public Homme() {
    }

    public Homme(String nom, String prenom, String telephone, String adresse, Date dateNaissance, List<Mariage> mariages) {
        super(nom, prenom, telephone, adresse, dateNaissance);
        this.mariages = mariages;
    }

    public Homme(String nom, String prenom, String telephone, String adresse, Date dateNaissance) {
        super(nom, prenom, telephone, adresse, dateNaissance);
    }

    public void setMariages(List<Mariage> mariages) {
        this.mariages = mariages;
    }
}
