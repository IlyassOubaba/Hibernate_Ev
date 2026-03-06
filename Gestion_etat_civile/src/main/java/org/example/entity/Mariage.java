package org.example.entity;
import javax.persistence.*;
import java.util.Date;

@Entity
public class Mariage {

    @EmbeddedId
    private MariageId mariageId;

    @Temporal(TemporalType.DATE)
    private Date dateDebut;

    @Temporal(TemporalType.DATE)
    private Date dateFin;

    private int nbrEnfant;

    @ManyToOne
    private Homme homme;

    @ManyToOne
    private Femme femme;

    public Mariage() {
    }

    public Mariage(Date dateDebut, Date dateFin, int nbrEnfant, Homme homme, Femme femme) {
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.nbrEnfant = nbrEnfant;
        this.homme = homme;
        this.femme = femme;

        homme.getMariages().add(this);
        femme.getMariages().add(this);
    }

    public MariageId getMariageId() {
        return mariageId;
    }

    public void setMariageId(MariageId mariageId) {
        this.mariageId = mariageId;
    }

    public Date getDateDebut() {
        return dateDebut; }
    public Date getDateFin() {
        return dateFin; }
    public int getNbrEnfant() {
        return nbrEnfant; }
    public Homme getHomme() {
        return homme; }
    public Femme getFemme() {
        return femme; }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut; }
    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin; }
    public void setNbrEnfant(int nbrEnfant) {
        this.nbrEnfant = nbrEnfant; }
    public void setHomme(Homme homme) {
        this.homme = homme; }
    public void setFemme(Femme femme) {
        this.femme = femme; }
}
