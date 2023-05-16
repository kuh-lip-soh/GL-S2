

import java.awt.image.BufferedImage;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.Socket;

import javax.imageio.ImageIO;





class Client3 implements Runnable {
    private String dataType;
    private String filePath;
    private String username;
    private String password;
	private Socket clientSocket;

    public Client3(String dataType, String filePath, String username, String password) {
        this.dataType = dataType;
        this.filePath = filePath;
        this.username = username;
        this.password = password;
    }
    public Client3(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    public void run() {
        try { 
            // etablir la connexion avec le serveur
            Socket socket = new Socket("localhost", 9001);

            // Envoyer le nom d'utilisateur et le mot de passe au serveur
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            out.writeUTF(username);
            out.writeUTF(password);

            // Lire la reponse du serveur
            DataInputStream in = new DataInputStream(socket.getInputStream());
            String authenticationResult = in.readUTF();

            if (authenticationResult.equals("success")) {
                // Authentification reussie
                out.writeUTF(dataType);

                if (dataType.equals("Image")) {
                    BufferedImage bimg;
                    bimg = ImageIO.read(new File(filePath));
                    System.err.println(bimg);
                    ImageIO.write(bimg,"JPG",clientSocket.getOutputStream());
                    System.out.println("Image envoyee");
                } else if (dataType.equals("Fichier Texte")) {
                    ABC.mystere(new FileInputStream(filePath), socket.getOutputStream());
                    System.out.println("Fichier texte envoye");
                }

                // ...
            } else {
                // Authentification echouee
                System.out.println("Authentification echouee. Fermeture de la connexion.");
            }
                   
            out.close();
            in.close();
            socket.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
