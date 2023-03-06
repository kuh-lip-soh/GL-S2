import java.io.Serializable;
public class Employee implements Serializable {

	private static final long serialVersionUID = 1L;

	public String nom; 
	static String prenom;
	transient final String adresse="CCC";
	transient static String affiliation;

 }
