package models;

import java.util.Date;

public class Voiture {
    private int id;
    private String marque;
    private String model;
    private Date date;
    private String etat;
    private String couleur;

    public Voiture(int id,String marque, String model, Date date, String etat, String couleur) {
        this.id = id;
        this.marque = marque;
        this.model = model;
        this.date = date;
        this.etat = etat;
        this.couleur = couleur;
    }

    // Getters et setters pour toutes les propriétés
    public String getMarque() {
        return marque;
    }
    public void setMarque(String marque) {
        this.marque = marque;
    }
    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }
    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }
    public String getEtat() {
        return etat;
    }
    public void setEtat(String etat) {
        this.etat = etat;
    }
    public String getCouleur() {
        return couleur;
    }
    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }

    public int getID(){
        return id;
    }
    public void setID(int id) {
        this.id = id;
    }

}

