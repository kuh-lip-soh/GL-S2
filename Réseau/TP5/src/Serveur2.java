import java.io.*;
import java.net.*;

public class Serveur2 {

    public static void main(String[] args) {
        try {
            try (ServerSocket serv = new ServerSocket(5555)) {
                System.out.println("Serveur prêt");

                while (true) {
                    Socket sock = serv.accept();
                    BufferedReader sockIn = new BufferedReader(new InputStreamReader(sock.getInputStream()));
                    PrintWriter sockOut = new PrintWriter(sock.getOutputStream(), true);

                    String nomPatient = sockIn.readLine();
                    System.out.println("Requête reçue pour le patient " + nomPatient);

                    String symptomes = chercherSymptomes(nomPatient);
                    sockOut.println(symptomes);

                    sock.close();
                }
            }
        } catch (IOException e) {
            System.out.println("Erreur lors de l'exécution du serveur");
            e.printStackTrace();
            System.exit(-1);
        }
    }

    public static String chercherSymptomes(String nomPatient) {
        String ligne;
        String symptomes = "";
        try {
            BufferedReader fichier = new BufferedReader(new FileReader("C:/Users/wafaa_pc/Desktop/islem_master/java_algo/tp5/exo1/symptomesnom.txt"));
            while ((ligne = fichier.readLine()) != null) {
                String[] elements = ligne.split(" ");
                if (elements[0].equalsIgnoreCase(nomPatient)) {
                    symptomes += elements[1] + " ";
                }
            }
            fichier.close();
        } catch (IOException e) {
            System.out.println("Erreur lors de la lecture du fichier");
            e.printStackTrace();
        }
        return symptomes.trim();
    }
}
