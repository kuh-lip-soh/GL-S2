import java.io.*;
import java.net.*;
import java.util.Enumeration;
public class UDPSocketClient {
public static void main(String[] args) throws Exception {
    
    
Entreprise entreprise = new Entreprise(10, "SOGERHWIT");  
DatagramSocket serverSocket = new DatagramSocket();
InetAddress group = InetAddress.getByName("224.0.0.1");

// définir une structure dans laquelle les données sont écrites dans un tableau d'octets
ByteArrayOutputStream a = new ByteArrayOutputStream ( ); // classe fille de OutputStream
ObjectOutputStream b = new ObjectOutputStream(a);
b.writeObject (entreprise);
//copier le contenu de a (OutputStream) dans un tableau d'octets pour l'utiliser dans DatagramPacket
byte[ ] data = a.toByteArray();
DatagramPacket envoyer = new DatagramPacket(data, data.length, group,4455);
serverSocket.send(envoyer);
byte[] buffer = new byte[1024];
System.out.println("Objet envoyé par le client");
DatagramPacket recu = new DatagramPacket(buffer,buffer.length);
serverSocket.receive(recu);
String response = new String(recu.getData());
System.out.println("Réponse du serveur : " + response);
serverSocket.close();
}
}
