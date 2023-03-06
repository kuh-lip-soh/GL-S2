import java.io.*;
import java.net.*;
import java.util.StringTokenizer;

public class ClientEcho {
    public static void main(String[] args) throws IOException {
        Socket sock = null;
        OutputStream sockOut = null;
        InputStream sockIn = null;
        String hello = "brr GL MASTER";

        try {
            sock = new Socket("localhost", 7777);
            sockOut = sock.getOutputStream();
            sockIn = sock.getInputStream();
        } catch (UnknownHostException e) {
            System.err.println("Host non atteignable : localhost");
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Connexion impossible avec : localhost");
            System.exit(1);
        }
        byte[ ] buffer1 = new byte[1024];
        buffer1 = hello.getBytes();
        try {
            sockOut.write(buffer1);
            sockOut.flush();
        } catch (IOException e) {}

        byte[ ] buffer2 = new byte[1024];

        try{

            int lu = sockIn.read(buffer2);
            System.out.println("Nombre des Mots envoyé par le serveur est : "+ new String(buffer2));
            for (int i = 0; i<lu; i++){
                sockIn.read(buffer2);
                System.out.println("" + new String(buffer2));
            }
        }
        catch (IOException e) {

        }

        sockOut.close();
        sockIn.close();
        sock.close();
    }
}
