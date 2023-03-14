import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Carnet extends UnicastRemoteObject {
	private String message;
	
	protected Carnet(String message) throws RemoteException {
		this.message = message;
	}
	
	public String say() throws RemoteException {
		return this.message;
	}
}
