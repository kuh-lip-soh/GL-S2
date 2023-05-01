import java.rmi.*;
import java.util.List;

public interface CarnetInterface extends Remote {
    public void enregistrer(String nom, Adresse adresse) throws RemoteException;
    public void effacer(String nom) throws RemoteException;
    public Adresse chercher(String nom) throws RemoteException;
    public List<Adresse> lister() throws RemoteException;
}
