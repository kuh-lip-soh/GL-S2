package controllers;

public class Adresse {
    private String nom;
    private int numeroRue;
    private String nomVille;
    
    public Adresse(String nom, int numeroRue, String nomVille) {
        this.nom = nom;
        this.numeroRue = numeroRue;
        this.nomVille = nomVille;
    }
    
    public String getNom() {
        return nom;
    }
    
    public void setNom(String nom) {
        this.nom = nom;
    }
    
    public int getNumeroRue() {
        return numeroRue;
    }
    
    public void setNumeroRue(int numeroRue) {
        this.numeroRue = numeroRue;
    }
    
    public String getNomVille() {
        return nomVille;
    }
    
    public void setNomVille(String nomVille) {
        this.nomVille = nomVille;
    }
}
