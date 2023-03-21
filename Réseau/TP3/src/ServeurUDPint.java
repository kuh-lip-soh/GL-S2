import java.io.*;
import java.net.*;
public class ServeurUDPint {
    public static void main(String[] args) throws Exception {
         DatagramSocket socket = new DatagramSocket(2000);
         byte [ ] buf = new byte[1024];
        DatagramPacket packet = new DatagramPacket(buf , buf.length);
        socket.receive(packet);
        readObject(packet);
        
        
        
}
    public static void readObject(DatagramPacket packet) throws IOException, ClassNotFoundException
    {
        ObjectInputStream objectInputStream = new ObjectInputStream(new ByteArrayInputStream(packet.getData()));
        Object tab = objectInputStream.readObject();
        
        int []t=(int[]) tab;
        for(int i=0;i<t.length;i++)
            System.out.print(t[i]+" | ");
        
    }
    public static void readINT(DatagramPacket packet) throws IOException {
                byte[] data = packet.getData();
        ByteArrayInputStream a = new ByteArrayInputStream(data);
         DataInputStream b = new DataInputStream(a);
         for(int i=0;i<packet.getLength();i=i+4)
         {  
             System.out.print(b.readInt()+" | ");}

    
    }
}

