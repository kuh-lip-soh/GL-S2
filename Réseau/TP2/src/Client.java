import java.io.*;
import java.net.*;

public class Client {
	public static void main(String[ ] args){
		try {
			String recu;
			Socket sock;
			sock = new Socket("localhost", 2022);
			PrintWriter sockOut = new PrintWriter(sock.getOutputStream(), true); 
			BufferedReader  sockIn = new BufferedReader(new InputStreamReader(sock.getInputStream()));
			sockOut.println("C'est BON");
			if ((recu = sockIn.readLine())!=null) 
				System.out.println(recu);
			sock.close();  
		} catch (IOException e) { }
	}
}
