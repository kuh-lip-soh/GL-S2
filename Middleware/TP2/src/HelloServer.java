import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class HelloServer {
	public static void main(String[] argv) {
		try {
			LocateRegistry.createRegistry(1099);
			Naming.rebind("rmi://localhost:1099/Hello",new Hello("Hello world"));
			System.out.println("Hello server is ready");
		} 	catch(Exception e) {
			System.out.println("Hello server is failed");
		}
	}
}