public class Etudiant {
    public String nom;
    public double note;
    
    public Etudiant (String nom, double note)
    {
        this.nom=nom;
        this.note=note;
    }
    
    public double Mark()
    {
        return note;
    }

    @Override
    public String toString()
    {
        return "Nom : " + nom + " - Note : " + note;
    }
}
