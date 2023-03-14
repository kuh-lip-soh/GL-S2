import java.rmi.*;

public class HelloClient {
	public static void main(String[] argv) {
		try {
			HelloInterface hello = (HelloInterface) Naming.lookup("rmi://localhost:1099/Hello");
			System.out.println(hello.say());
		} catch(Exception e) {
			System.out.println("HelloClient Exception: "+e);
		}
	}
}