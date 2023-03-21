import java.io.*;
import java.net.*; 
public class Recepteur {      
 public static void main(String argv [ ]) throws IOException, ClassNotFoundException{ 
        InetAddress group = InetAddress.getByName ("235.1.1.1");
        MulticastSocket socket = new MulticastSocket (4000) ;
        socket.joinGroup (group);
        byte [ ] buf = new byte[1024];
        DatagramPacket recv = new DatagramPacket(buf, buf.length);
        System.out.println("En attente de reception ...");
        socket.receive(recv);
        ObjectInputStream objectInputStream = new ObjectInputStream(new ByteArrayInputStream(recv.getData()));
        Object entreprise = objectInputStream.readObject();
        
        
        System.out.println("L’objet entreprise recu : " +entreprise+ " \nFin reception");
 }
}

