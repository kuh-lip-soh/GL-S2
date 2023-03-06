import java.net.*;
import java.io.*;

class ServerEtudiant {
  @SuppressWarnings("resource")
public static void main(String args[]) {
    Etudiant[ ] tabEtudiant = { 
    		new Etudiant ("Nazim", "MID", 9), 
    		new Etudiant ("B", "MID", 10),
    		new Etudiant ("C", "MID", 11),
    		new Etudiant ("Meriem", "RSD", 12),
    		new Etudiant ("B", "RSD", 13),
    		new Etudiant ("C", "RSD", 14),
    		new Etudiant ("A", "SIC", 14),
    		new Etudiant ("B", "SIC", 16),
    		new Etudiant ("C", "SIC", 10),
    		new Etudiant ("A", "GL", 12),
    		new Etudiant ("Mehdi", "GL", 10),
    		new Etudiant ("Chaima", "GL", 14)
    };
    
    try {
      ServerSocket server = new ServerSocket(8888);

      while (true) {
        Socket sock = server.accept();
        System.out.println("Connecté");
        ObjectOutputStream sockOut = new  ObjectOutputStream(sock.getOutputStream());
        BufferedReader sockIn = new BufferedReader(new InputStreamReader(sock.getInputStream()));
        String recu;  
        while ((recu = sockIn.readLine()) != null) {
        	System.out.println("Recu :"+recu);
        	//String nom = recu.trim();
        	int moy = Integer.parseInt((recu).trim()); // Moyenne
        	int j=0;
        	Etudiant[] tab = new Etudiant [12];
        	for (int i=0; i<tabEtudiant.length; i++)
        		/*
        		if (tabEtudiant[i].getNom().equals(nom)){
        			sockOut.writeObject(tabEtudiant[i]);
            		break; 
        		}
        		*/
        		if (tabEtudiant[i].getMoy()>=moy){ // Moyenne
    			tab[j]=tabEtudiant[i];
    			j++;
    		}
        	sockOut.writeObject(tab);
        }
        sockOut.close(); 
        sock.close();
      } 
    } catch (IOException e) {}
  }
}