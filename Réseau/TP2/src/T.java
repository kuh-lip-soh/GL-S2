import java.io.*;
import java.net.Socket;
import java.util.StringTokenizer;

class T extends Thread {
    private Socket sock;
    public T(Socket  s){
        sock = s;
    }
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName());
            int lu;
            OutputStream sockOut = sock.getOutputStream();
            InputStream sockIn = sock.getInputStream();
            byte[ ] buffer1 = new byte[1024];
            lu = sockIn.read(buffer1);
            System.out.println("Mot envoyé par le client est : "+new String(buffer1));
            System.out.println("Nombre d'octets lu : "+lu);
            StringTokenizer st = new StringTokenizer(new String(buffer1));
            // appelle à mon méthode
            sockOut.write(st.countTokens());
            while(st.hasMoreTokens()){

                byte c = ServerEcho.get_first_char(st.nextToken());
                System.out.println(c);
                sockOut.write(c);
            }
            sockOut.flush();
            //byte[ ] buffer2 = new byte[1024];
            //buffer2 = hello.getBytes();
            sockOut.close();
        } catch (IOException e) {}

        try {
            sock.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    } // Fin run
} // Fin class T

