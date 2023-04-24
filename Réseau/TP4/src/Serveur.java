import java.net.*;
import java.io.*;
import java.util.HashMap;

class Serveur {
private HashMap<String, Double> table;

public Serveur() {
table = new HashMap<>();
table.put("badr", 13.5);
table.put("saleh", 15.5);
table.put("youcef", 9.5);
table.put("anes", 8.5);
 }

public boolean TrouverMoy (String name) {
  if (table.get(name)>10)   return true;
  else return false; 
 }
    
public static void main(String args[]) {
    Serveur b = new Serveur();
    System.out.println("Serveur en attente de connexion ..."); 
    ServerSocket server = null;
    try {
      server = new ServerSocket(7777); 
      while (true) {
        Socket sock = server.accept(); 
        System.out.println("Connecté"); 
        DataOutputStream sockOut = new DataOutputStream(sock.getOutputStream()); 
        DataInputStream sockIn = new DataInputStream(sock.getInputStream());
        String name;   
        
        while ((name = sockIn.readUTF()) != null)  {
            sockOut.writeBoolean(b.TrouverMoy (name));
            sockOut.flush();
        }
        
        sockOut.close();
        sock.close();
      } 
    } catch (IOException e) {try {server.close();} catch (IOException e2) {}} 
}
}
