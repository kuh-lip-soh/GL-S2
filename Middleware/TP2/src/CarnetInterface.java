import java.rmi.*;

public interface CarnetInterface extends Remote {
	public String say() throws RemoteException;	
}
