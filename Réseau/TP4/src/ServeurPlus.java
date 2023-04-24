import java.net.*;
import java.io.*;
import java.util.HashMap;
import java.util.ArrayList;

class ServeurPlus {
private HashMap<String, Integer> table;
private ArrayList<Etudiant> GL;
private ArrayList<Etudiant> RSD;
private ArrayList<Etudiant> SIC;
private ArrayList<Etudiant> MID;

public ServeurPlus() {
table = new HashMap<>();
table.put("GL", 1);
table.put("RSD", 2);
table.put("SIC", 3);
table.put("MID", 4);

Etudiant a = new Etudiant("chaima", 13.5);
Etudiant b = new Etudiant("mehdi", 14.5);
Etudiant c = new Etudiant("shmem", 10.5);
Etudiant d = new Etudiant("zoubir", 13.5);
Etudiant e = new Etudiant("Lhadi", 11.5);
Etudiant f = new Etudiant("Riad", 15.5);
Etudiant g = new Etudiant("Meriem", 12.75);
Etudiant h = new Etudiant("Random", 7.5);
Etudiant i = new Etudiant("Nazim", 12.25);
Etudiant j = new Etudiant("Imad", 15.5);

GL.add(a);
GL.add(b);
GL.add(c);
GL.add(d);

RSD.add(e);
RSD.add(f);
SIC.add(g);
SIC.add(h);
MID.add(i);
MID.add(j);

 }

public String TrouverMoy (String name) {
    int j=0;
  switch(table.get(name))
  {
      case 1 :
          for(int i=1; i<GL.size(); i++)
              if(GL.get(i).Mark()>GL.get(j).Mark())
                  j=i;
          return GL.get(j).toString();
      case 2 :
          for(int i=1; i<RSD.size(); i++)
              if(RSD.get(i).Mark()>RSD.get(j).Mark())
                  j=i;
          return RSD.get(j).toString();
      case 3 :
          for(int i=1; i<SIC.size(); i++)
              if(SIC.get(i).Mark()>SIC.get(j).Mark())
                  j=i;
          return SIC.get(j).toString();
      case 4 :
          for(int i=1; i<MID.size(); i++)
              if(MID.get(i).Mark()>MID.get(j).Mark())
                  j=i;
          return MID.get(j).toString();
  }
  return "Erreur";
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
