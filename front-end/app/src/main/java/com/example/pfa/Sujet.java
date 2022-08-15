package com.example.pfa;

public class Sujet {

    private String titre;
    private String encadrant;
    private int nbMax;

    public Sujet() {

    }



    public Sujet (String titre, String encadrant, int nbMax){
        this.titre = titre;
        this.encadrant = encadrant;
        this.nbMax = nbMax;

    }

    public int getNbMax() {
        return nbMax;
    }

    public String getEncadrant() {
        return encadrant;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public void setEncadrant(String encadrant) {
        this.encadrant = encadrant;
    }

    public void setNbMax(int nbMax) {
        this.nbMax = nbMax;
    }
}
