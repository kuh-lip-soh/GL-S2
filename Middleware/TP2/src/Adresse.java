import java.io.Serializable;

public class Adresse implements Serializable {
    private static final long serialVersionUID = 1L;
    private String nom;
    private int rue;
    private String ville;

    public Adresse(String nom, int rue, String ville) {
        this.nom = nom;
        this.rue = rue;
        this.ville = ville;
    }
    public String toString() {
        return "Nom : " + nom + " - Rue : " + rue + " - Ville : " + ville;
    }
}