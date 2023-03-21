import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.Enumeration;
public class FIFAClient {
public static void main(String[] args) throws Exception {
    
    
char search = 'M';
int num = 10;
String eq = "PSG";

DatagramSocket serverSocket = new DatagramSocket();
InetAddress group = InetAddress.getByName("localhost");
// définir une structure dans laquelle les données sont écrites dans un tableau d'octets
ByteArrayOutputStream a = new ByteArrayOutputStream (); // classe fille de OutputStream
ObjectOutputStream b = new ObjectOutputStream(a);

b.writeObject (search);
byte[ ] data = a.toByteArray();
DatagramPacket envoyer = new DatagramPacket(data, data.length, group,4455);
serverSocket.send(envoyer);
System.out.println("Objet envoyé");

byte[] buffer = new byte[1024];
DatagramPacket recu = new DatagramPacket(buffer,buffer.length);
serverSocket.receive(recu);
ObjectInputStream objectInputStream = new ObjectInputStream(new ByteArrayInputStream(recu.getData()));
Object rep = objectInputStream.readObject();
ArrayList<Joueur> reponse= new ArrayList<Joueur>();
reponse = (ArrayList<Joueur>) rep;
System.out.println("Réponse du serveur :");
    for(int i=0;i<reponse.size();i++)
    {
        System.out.println(reponse.get(i).toString());
    }

//2eme
a = new ByteArrayOutputStream (); // classe fille de OutputStream
b = new ObjectOutputStream(a);
b.writeObject (num);
data = a.toByteArray();
envoyer = new DatagramPacket(data, data.length, group,4455);
serverSocket.send(envoyer);
System.out.println("Objet envoyé");

buffer = new byte[1024];
recu = new DatagramPacket(buffer,buffer.length);
serverSocket.receive(recu);
objectInputStream = new ObjectInputStream(new ByteArrayInputStream(recu.getData()));
rep = objectInputStream.readObject();
reponse= new ArrayList<Joueur>();
reponse = (ArrayList<Joueur>) rep;
System.out.println("Réponse du serveur :");
    for(int i=0;i<reponse.size();i++)
    {
        System.out.println(reponse.get(i).toString());
    }

//3eme
a = new ByteArrayOutputStream (); // classe fille de OutputStream
b = new ObjectOutputStream(a);
b.writeObject (eq);
data = a.toByteArray();
envoyer = new DatagramPacket(data, data.length, group,4455);
serverSocket.send(envoyer);
System.out.println("Objet envoyé");

buffer = new byte[1024];
recu = new DatagramPacket(buffer,buffer.length);
serverSocket.receive(recu);
objectInputStream = new ObjectInputStream(new ByteArrayInputStream(recu.getData()));
rep = objectInputStream.readObject();
reponse= new ArrayList<Joueur>();
reponse = (ArrayList<Joueur>) rep;
System.out.println("Réponse du serveur :");
    for(int i=0;i<reponse.size();i++)
    {
        System.out.println(reponse.get(i).toString());
    }

serverSocket.close();
}
}
