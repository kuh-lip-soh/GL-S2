import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class UDPSocketServer {
public static void main(String[] args) throws Exception {
MulticastSocket socket = new MulticastSocket(4455);
        InetAddress group = InetAddress.getByName("224.0.0.1");
        socket.joinGroup(group);
        byte[] buffer = new byte[1000];
        DatagramPacket recu = new DatagramPacket(buffer, buffer.length);
        socket.receive(recu);
        ObjectInputStream objectInputStream = new ObjectInputStream(new ByteArrayInputStream(recu.getData()));
        Object entreprise = objectInputStream.readObject();
        System.out.println("L'objet entreprise reçu : "+entreprise);
        
InetAddress IPAddress = recu.getAddress();
int port = recu.getPort();
String reponse = "J'ai bien reçu l'objet de la machine : "+IPAddress;
byte[ ] d = reponse.getBytes();
DatagramPacket envoyer =new DatagramPacket(d, d.length, IPAddress, port);
socket.send(envoyer);
//socket.leaveGroup(group);
socket.close();

}
}

