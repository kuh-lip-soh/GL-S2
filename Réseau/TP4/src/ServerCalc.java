import java.io.*;
import java.net.*;
public class ServerCalc {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(6666);
        while (true) {      
            Socket socket = server.accept();
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream()); 
            DataInputStream dis = new DataInputStream(socket.getInputStream());
            String requete = "";
            while ((requete = dis.readUTF()) != null) {
                
                String [] tmp = requete.split(" ");
                String opperation = tmp[0];
                int opd1 = Integer.parseInt(tmp[1]);
                int opd2 = Integer.parseInt(tmp[2]);
                String resultat;

                switch(opperation) {
                    case "ADD" : resultat = String.valueOf(opd1 + opd2);
                        break;
                    case "MUL" : resultat = String.valueOf(opd1 * opd2);
                        break;
                    case "SOUS" : resultat = String.valueOf(opd1 - opd2);
                        break;
                    case "DIV" : resultat = String.valueOf((double) opd1 / opd2);
                        break;
                    case "PUIS" : resultat = String.valueOf(Math.pow(opd1, opd2));
                        break;
                    default: resultat = "Erreur";
                        break;
                }
                dos.writeUTF(resultat);                
                
            }                 
        }
    }    
}
