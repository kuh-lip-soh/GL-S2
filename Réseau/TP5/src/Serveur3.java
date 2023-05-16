
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.*;
import java.util.HashMap;

import javax.imageio.ImageIO;



public class Serveur3 {
    private static final HashMap<String, String> utilisateur = new HashMap<>();

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9001);
        System.out.println("Serveur en attente de connexions...");

        // Ajouter les utilisateurs autoris�s � la hashmap
        utilisateur.put("ghennou", "123");
        utilisateur.put("ouafi", "456");

        while (true) {
            Socket clientSocket = serverSocket.accept();
            System.out.println("Nouveau client connect� : " + clientSocket);

            // Cr�er un thread pour g�rer le client
            Thread clientThread = new Thread(new GestionClient(clientSocket));
            clientThread.start();
        }
    }

    private static class GestionClient implements Runnable {
        private Socket clientSocket;

        public GestionClient(Socket clientSocket) {
            this.clientSocket = clientSocket;
        }

        public void run() {
            try {
                // Lire le nom d'utilisateur et le mot de passe envoy�s par le client
                DataInputStream in = new DataInputStream(clientSocket.getInputStream());
                String username = in.readUTF();
                String password = in.readUTF();

                // V�rifier l'authentification
                boolean isAuthenticated = authenticateUser(username, password);

                // Envoyer le resultat de l'authentification au client
                DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());
                if (isAuthenticated) {
                    out.writeUTF("success");
                    String dataType = in.readUTF();
                    if (dataType.equals("Image")) {
                        // Traitement pour les images
                       BufferedImage img=ImageIO.read(ImageIO.createImageInputStream(clientSocket.getInputStream()));
                        ImageIO.write(img, "JPG", new File("./src/test.JPG"));
                        System.out.println("Image recue");
                    } else if (dataType.equals("Fichier Texte")) {
                        // Traitement pour les fichiers texte
                        ABC.mystere(clientSocket.getInputStream(), new FileOutputStream("./src/test2.txt"));
                        System.out.println("Fichier texte recu");
                    }

                } else {
                    out.writeUTF("failure");
                }

                // ...
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

        private boolean authenticateUser(String username, String password) {
            // V�rifier les informations d'authentification dans la hashmap
            String storedPassword = utilisateur.get(username);
            return storedPassword != null && storedPassword.equals(password);
        }
    }
}
