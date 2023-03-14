package controllers;
import java.util.HashMap;

public class Carnet {
	HashMap<String,Adresse> adresses=new HashMap<String,Adresse>();
	  private String nom;
	  public Carnet() {
		super();
	}
	  public Carnet(String nom) {
		  this.nom=nom;
	  }
	public Carnet(String nom,Adresse adresse) {
		
		this.nom=nom;
		this.adresses.put(adresse.getNom(), adresse);
	}
	
	public void Enregister(Adresse adresse) {
		this.adresses.put(adresse.getNom(), adresse);
		
	}
	public void Supprimer(Adresse adresse)
	{
		this.adresses.remove(adresse.getNom());
	}
	public Adresse chercher(String nom)
	{
		return this.adresses.get(nom);
	}
	
	
	public HashMap<String, Adresse> getAdresses() {
        return adresses;
    }
    
    public String getNom() {
        return nom;
    }
    
    
    
    

}
