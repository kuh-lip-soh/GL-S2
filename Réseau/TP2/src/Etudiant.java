import java.io.Serializable;

public class Etudiant implements Serializable{
	
	private static final long serialVersionUID = 1L;
	String nom;
	String specialite;
	int moy;
	
	Etudiant (String nom, String specialite, int moy) {
		this.nom = nom; 
		this.specialite = specialite;
		this.moy = moy;
	}
	
    String getNom() {
    	return nom;
    }
    
    int getMoy() {
    	return moy;
    }
    
    public String toString() {
    	return "Etudiant : "+nom+"   "+specialite+" : "+moy;
    } 
  
}