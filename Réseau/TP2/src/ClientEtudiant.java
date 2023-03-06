import java.io.*; 
import java.net.*;

public class ClientEtudiant {
  public static void main(String[] args) throws IOException {
	  String hostName = "localhost"; 
	  int port = 8888;
	  String NomEtudiant = "A";  
	  int min = 12;
	  Socket sock = null;
	  PrintWriter sockOut = null;
	  ObjectInputStream sockIn = null;
	  try {
		  sock = new Socket(hostName, port);
		  sockOut = new PrintWriter(sock.getOutputStream(), true);
		  sockIn = new ObjectInputStream(sock.getInputStream());
	  } catch (UnknownHostException e) {
		  System.err.println("Host non atteignable : "+hostName);
		  System.exit(1);
	  }  catch (IOException e) {
		  System.err.println("Connexion impossible avec : "+hostName);
		  System.exit(1);
	  }
	  
      //sockOut.println(NomEtudiant); // envoyer le nom au serveur
      sockOut.println(min); // moyenne minimale
     try {
    	  Object recu = sockIn.readObject(); // récupérer l’objet Etudiant envoyé par le serveur
    	  if (recu == null) 
    		  System.out.println("Erreur de connexion");
    	  else { 
    		  Etudiant[] etudiant = (Etudiant[])recu; // Moyenne
    		  //Etudiant etudiant = (Etudiant)recu;
    		  System.out.println("Port local : " +sock.getLocalPort()+ "   Port distant : "+ sock.getPort());
    		  System.out.println("Serveur -> Client :");
    		  //System.out.println(etudiant);
    		  for(int i=0; etudiant[i]!=null; i++) // Moyenne
    			  System.out.println(etudiant[i]);
    	  }
      } catch (ClassNotFoundException e) {
    	  System.err.println("Classe inconnue : "+hostName);
    	  System.exit(1);
      }  
    sockOut.close();
    sockIn.close();
    sock.close();
  }
}