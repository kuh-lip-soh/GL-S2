import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Hello extends UnicastRemoteObject implements HelloInterface {
	private String message;
	
	protected Hello(String message) throws RemoteException {
		this.message = message;
	}
	
	public String say() throws RemoteException {
		return this.message;
	}
}
