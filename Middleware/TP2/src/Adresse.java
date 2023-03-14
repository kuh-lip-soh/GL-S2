import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Adresse extends UnicastRemoteObject implements CarnetInterface {
	private String nom;
        private int rue;
        private String ville;
	
	protected Adresse(String nom, int rue, String ville) throws RemoteException {
		this.nom = nom;
                this.rue = rue;
                this.ville = ville;
        }
	
	public String say() throws RemoteException {
		return ("Nom : " + this.nom + "\nRue :  " + this.rue + "\nVille : " + this.ville);
	} 
}
