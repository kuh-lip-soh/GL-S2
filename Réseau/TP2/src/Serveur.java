import java.io.*;
import java.net.*;

public class Serveur {
	public static void main(String[] args) throws IOException{
		int nbrclient=0; 
		ServerSocket a;
		a = new ServerSocket(2022);
		while (true){ 
			try {
				Socket s=a.accept(); 
				nbrclient++;
				System.out.println("J'ai "+nbrclient+ " clients");
				T thread = new T(s);  
				thread.start(); 
			} catch (IOException e) {}
		} // Fin while 
	} // Fin main 
} // Fin Serveur
