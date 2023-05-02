import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Carnet extends UnicastRemoteObject implements CarnetInterface {
    private static final long serialVersionUID = 1L;
    private Map<String, Adresse> adresses;

    public Carnet() throws RemoteException {
        super();
        adresses = new HashMap<String, Adresse>();
    }
	
	 public synchronized void enregistrer(String nom, Adresse adresse) throws RemoteException {
            adresses.put(nom, adresse);
        }

        public synchronized void effacer(String nom) throws RemoteException {
            adresses.remove(nom);
        }

        public synchronized Adresse chercher(String nom) throws RemoteException {
            return adresses.get(nom);
        }

        public synchronized List<Adresse> lister() throws RemoteException {
            return new ArrayList<Adresse>(adresses.values());
        }
}
