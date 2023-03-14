import java.rmi.*;

public class CarnetClient {
	public static void main(String[] argv) {
		try {
			CarnetInterface carnet = (CarnetInterface) Naming.lookup("rmi://localhost:1099/Carnet");
			System.out.println(carnet.say());
		} catch(Exception e) {
			System.out.println("HelloClient Exception: "+e);
		}
	}
}