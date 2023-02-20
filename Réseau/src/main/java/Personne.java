import java.io.Serializable;
public class Personne implements Serializable {

	private static final long serialVersionUID = 1L;

	public String nom; 
	public String prenom;
	public int age;
	
	public String toString(int n) {
		return 	"Nom : " +nom+ " - Prenom : " +prenom+ " - Age : " +toString(n);
	}

 }
