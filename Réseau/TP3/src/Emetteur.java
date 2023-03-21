import java.io.*;
import java.net.*; 
public class Emetteur {      
 public static void main(String argv [ ]) throws IOException{ 
        Entreprise entreprise=new Entreprise(12, "SONELGAZ");
        InetAddress group = InetAddress.getByName ("235.1.1.1");
        DatagramSocket socket = new DatagramSocket () ;
        ByteArrayOutputStream a = new ByteArrayOutputStream ( ); // classe fille de OutputStream
        ObjectOutputStream b = new ObjectOutputStream(a);
        b.writeObject (entreprise);
        byte [ ] msg=a.toByteArray();
        DatagramPacket hi = new DatagramPacket(msg,msg.length,group, 4000);
        socket.send(hi);
        System.out.println("Fin emission");
 }
}

