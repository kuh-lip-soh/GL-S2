import java.io.*;
import java.net.*;
import java.util.*;

public class Nacci {
     static ArrayList <Integer> result = new ArrayList<Integer>();

    public static int fibonacci(int n, int[] memo)
    {
        if(n<=0)
            return memo[0] = 0;
        else
        if (n == 1)
            return memo[1] = 1;
        else
            return memo[n] = fibonacci(n - 1, memo) + fibonacci(n - 2, memo);

    }

    public static void main(String[] args) {
        int result = 0;
        try {
            ServerSocket server = new ServerSocket(6666);
            Socket sock = server.accept();
            System.out.println("Connecté");
            DataOutputStream sockDataOut = new DataOutputStream(sock.getOutputStream());
            DataInputStream sockDataIn = new DataInputStream(sock.getInputStream());

            int recu = -1;

            while ((recu = sockDataIn.readInt()) != -1){
                int[] memo = new int[recu + 1];
                result = Nacci.fibonacci(recu, memo);
                sockDataOut.writeInt(memo.length);

                for (int i = 0; i < memo.length; i++) {
                    System.out.println(memo[i]);
                    sockDataOut.writeInt(memo[i]);
                }
                System.out.println(memo[1]);
                sockDataOut.flush();
            }
            //sockOut.close();
            sockDataOut.close();
            sock.close();
        }
        catch (IOException e) {
            System.out.println("ggez");
        }


    }




}
