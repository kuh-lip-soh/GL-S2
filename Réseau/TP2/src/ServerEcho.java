import java.net.*;
import java.io.*;
import java.util.StringTokenizer;

class ServerEcho {

    static public byte get_first_char(String st) {
        return st.getBytes()[0];
    }
    public static void main(String args[]) {

        Runnable instance  = new Runnable() {
            @Override
            public void run() {
                ServerSocket server = null;
                OutputStream sockOut = null;
                InputStream sockIn = null;
                String hello = "";

                try {
                    server = new ServerSocket(7777);
                    while (true) {
                        Socket sock = server.accept();
                        System.out.println("Connecté");
                        sockOut = sock.getOutputStream();
                        sockIn = sock.getInputStream();
                        byte[ ] buffer1 = new byte[1024];
                        int lu;

                        try {
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
                                sockOut.flush();
                            }
                            //byte[ ] buffer2 = new byte[1024];
                            //buffer2 = hello.getBytes();
                        } catch (IOException e) {}
                        sockOut.close();
                        sock.close();
                    }
                } catch (IOException e) {
                    try {server.close();} catch (IOException e2) {}
                }
            }
        };
        Thread test = new Thread(instance);
        test.start();

    }
}
