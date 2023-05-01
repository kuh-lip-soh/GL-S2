import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class CarnetServer {
	public static void main(String[] argv) {
		try {
			LocateRegistry.createRegistry(1099);
			Naming.rebind("rmi://localhost:1099/Carnet",new Carnet());
			System.out.println("Carnet en attente");
		} 	catch(Exception e) {
			System.out.println("Erreur : "+ e.getMessage());
		}
	}
}