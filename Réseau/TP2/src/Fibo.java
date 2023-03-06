import java.io.*;
import java.net.*;

public class Fibo {

    public static void main(String[] args) throws IOException {
        String hostName = "localhost";
        int num_fibo = 7;
        Socket sock = null;

        //PrintWriter sockOut = null;
        //ObjectInputStream sockIn = null;
        DataOutputStream sockDataOut = null;
        DataInputStream sockDataIn = null;
        try {
            sock = new Socket();
            sock.bind(new InetSocketAddress(8888));
            sock.connect(new InetSocketAddress("localhost", 6666));
            sockDataOut = new DataOutputStream(sock.getOutputStream());
            sockDataIn = new DataInputStream(sock.getInputStream());


        } catch (UnknownHostException e) {
            System.err.println("Host non atteignable : " + hostName);
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Connexion impossible avec : " + hostName);
            System.exit(1);
        }
        sockDataOut.writeInt(num_fibo);



        try {
            int length = sockDataIn.readInt();
            int[] numbers = new int[length];
            System.out.println("Suite Fibonacci de " +num_fibo+" :");
            for (int i = 0; i < length; i++) {
                numbers[i] = sockDataIn.readInt();
                System.out.print(numbers[i]+ " ");
            }
            System.out.println();

            if (length == 0)
                System.out.println("Erreur de connexion");
            else {
                System.out.println("Terminé");
            }
            sockDataOut.close();
            sockDataIn.close();
            sock.close();
        } catch (EOFException e) {
            throw new RuntimeException(e);
        }

    }
}


