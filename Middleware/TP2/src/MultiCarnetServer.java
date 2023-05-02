import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class MultiCarnetServer {
    public static void main(String[] args) throws Exception {
        Registry registry = LocateRegistry.createRegistry(1099);

        Carnet carnet1 = new Carnet();
        Naming.rebind("rmi://localhost/Carnet1", carnet1);

        Carnet carnet2 = new Carnet();
        Naming.rebind("rmi://localhost/Carnet2", carnet2);

        Carnet carnet3 = new Carnet();
        Naming.rebind("rmi://localhost/Carnet3", carnet3);
        
        String[] boundNames = registry.list();
        System.out.println("Objects bound to registry:");
        for (String name : boundNames) {
            System.out.println(name);
        }
    }
}