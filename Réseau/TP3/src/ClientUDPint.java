import java.io.*;
import java.net.*;
public class ClientUDPint { 
    
public static void main(String[] args) throws Exception {
        
        int [ ] tab = {1, 6, 8, 9, 13, 10};
        // Ecrire : 10 true bonjour 1.2 dans le outputstream
        sendObject(tab);
       
       System.out.println("Client a envoyé le tableau");
}
public static void sendObject(int []t) throws SocketException, UnknownHostException, IOException
{
        DatagramSocket socket = new DatagramSocket();                                
        InetAddress serveur = InetAddress.getByName("localhost");
        ByteArrayOutputStream a = new ByteArrayOutputStream();
        ObjectOutputStream b = new ObjectOutputStream(a);
        b.writeObject(t);
        byte[] buffer = a.toByteArray();
       DatagramPacket packet = new DatagramPacket(buffer,buffer.length,serveur ,2000); 
       socket.send(packet);
}
public static void sendINT(int [] t) throws SocketException, UnknownHostException, IOException
{
    DatagramSocket socket = new DatagramSocket();                                
        InetAddress serveur = InetAddress.getByName("localhost");
        ByteArrayOutputStream a = new ByteArrayOutputStream();
        DataOutputStream b = new DataOutputStream(a);
        for(int i=0;i<t.length;i++)
        {
            b.writeInt(t[i]);
        }
        b.flush();
       byte[] buffer = a.toByteArray();
       DatagramPacket packet = new DatagramPacket(buffer,buffer.length,serveur ,2000); 
       socket.send(packet);

}
}

