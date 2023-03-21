import java.io.*;
import java.net.*;
import java.util.ArrayList;

public class FIFAServer {
public static void main(String[] args) throws Exception {
    ArrayList<Joueur> liste = new ArrayList<Joueur>();
    Joueur a = new Joueur(9,"BENZEMA","RMA");
    Joueur b = new Joueur(30,"MESSI","PSG");
    Joueur c = new Joueur(10,"NEYMAR","PSG");
    Joueur d = new Joueur(10,"MODRIC","RMA");
    Joueur e = new Joueur(26,"MAHREZ","MNC");
    Joueur f = new Joueur(9,"RONALDINHO","FCB");
    liste.add(a);liste.add(b);liste.add(c);liste.add(d);liste.add(e);liste.add(f);
    
    MulticastSocket socket = new MulticastSocket(4455);
    InetAddress group = InetAddress.getByName("localhost");
    
    byte[] buffer = new byte[1000];
    DatagramPacket recu = new DatagramPacket(buffer, buffer.length);
    socket.receive(recu);
    ObjectInputStream objectInputStream = new ObjectInputStream(new ByteArrayInputStream(recu.getData()));
    char search = (char) objectInputStream.readObject();
    
    System.out.println("L'objet reçu : "+search);        
    ArrayList<Joueur> reponse = new ArrayList<Joueur>();
    for(int i=0; i<(liste.size());i++)
    {
        if(search==liste.get(i).getName().charAt(0))
            reponse.add(liste.get(i));
    }
        
    InetAddress IPAddress = recu.getAddress();
    int port = recu.getPort();
    ByteArrayOutputStream y = new ByteArrayOutputStream();
    ObjectOutputStream x = new ObjectOutputStream(y);
    x.writeObject(reponse);
    buffer = y.toByteArray();
    DatagramPacket envoyer =new DatagramPacket(buffer, buffer.length, IPAddress, port);
    socket.send(envoyer);
    
    //2eme
    recu = new DatagramPacket(new byte[1024],1024);   
    socket.receive(recu);
    objectInputStream = new ObjectInputStream(new ByteArrayInputStream(recu.getData()));
    Object o = objectInputStream.readObject();
    int num = (int) o;
    
    System.out.println("L'objet reçu : "+num);        
    reponse = new ArrayList<Joueur>();
    for(int i=0; i<(liste.size());i++)
    {
        if(num==liste.get(i).getId())
            reponse.add(liste.get(i));
    }
    
    y = new ByteArrayOutputStream();
    x = new ObjectOutputStream(y);
    x.writeObject(reponse);
    buffer = y.toByteArray();
    envoyer =new DatagramPacket(buffer, buffer.length, IPAddress, port);
    socket.send(envoyer);
    
    //3eme
    recu = new DatagramPacket(new byte[1024],1024);  
    socket.receive(recu);
    objectInputStream = new ObjectInputStream(new ByteArrayInputStream(recu.getData()));
    o = objectInputStream.readObject();
    String eq = (String) o;
    
    System.out.println("L'objet reçu : "+eq);        
    reponse = new ArrayList<Joueur>();
    for(int i=0; i<(liste.size());i++)
    {
        if(eq.trim().equals(liste.get(i).getTeam()))
            reponse.add(liste.get(i));
    }
    
    y = new ByteArrayOutputStream();
    x = new ObjectOutputStream(y);
    x.writeObject(reponse);
    buffer = y.toByteArray();
    envoyer =new DatagramPacket(buffer, buffer.length, IPAddress, port);
    socket.send(envoyer);
    
    socket.close();
}
}

