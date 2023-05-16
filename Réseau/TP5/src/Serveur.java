

import java.net.*;
import java.io.*;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Map;


// class Serveur {

//     /**
//      * @param args
//      */
//     public static void main(String[] args) {
//         try (ServerSocket s = new ServerSocket(5555)) {
//             System.out.println("Serveur démarré. En attente de clients...");
//             HashMap<String, Integer> map = new HashMap<>();
//             try (Scanner a = new Scanner(new File("C:/Users/wafaa_pc/Desktop/islem_master/java_algo/tp5/exo1/symptomes.txt"))) {
//                 while (a.hasNextLine())
//                     ajouter(map, a.nextLine());
//             }
    
//             while (true) {
//                 Socket sock = s.accept();
//                 System.out.println("Nouveau client connecté.");
//                 DataInputStream sockIn = new DataInputStream(sock.getInputStream());
//                 DataOutputStream sockOut = new DataOutputStream(sock.getOutputStream());
//                 Thread t = new Thread(() -> {
//                     try {
//                         while (true) {
//                             String symptome = sockIn.readUTF();
//                             int nombreDeFois = map.getOrDefault(symptome, 0);
//                             sockOut.writeInt(nombreDeFois);
//                             sockOut.flush();
//                         }
//                     } catch (IOException e) {
//                         System.out.println("Client déconnecté.");
//                     }
//                 });
//                 t.start();
//             }
//         } catch (IOException e) {
//             e.printStackTrace();
//         }
//     }
    
//     static void ajouter(Map<String, Integer> map, String symptome) {
//         map.compute(symptome, (key, value) -> (value == null) ? 1 : value + 1);
//     }
// }    


public class Serveur {
    public static void main(String[] args) {
        try (ServerSocket s = new ServerSocket(5555)) {
            System.out.println("Serveur prêt, en attente de clients...");
            Map<String, Integer> symptomesCount = new HashMap<>();
            // read the symptomes.txt file and populate the HashMap
            try (Scanner fileScanner = new Scanner(new File("C:/Users/wafaa_pc/Desktop/islem_master/java_algo/tp5/exo1/symptomes.txt"))) {
                while (fileScanner.hasNextLine()) {
                    ajouter(symptomesCount, fileScanner.nextLine());
                }
            } catch (IOException e) {
                System.err.println("Erreur lors de la lecture du fichier symptomes.txt : " + e.getMessage());
                System.exit(1);
            }
            while (true) {
                Socket client = s.accept();
                System.out.println("Un client est connecté.");
                Thread t = new Thread(new TraiteUnClient(client, symptomesCount));
                t.start();
            }
        } catch (IOException e) {
            System.err.println("Erreur lors de la création du serveur : " + e.getMessage());
            System.exit(1);
        }
    }

    static void ajouter(Map<String, Integer> map, String symptome) {
        map.compute(symptome, (key, value) -> (value == null) ? 1 : value + 1);
    }

    static class TraiteUnClient implements Runnable {
        private final Socket client;
        private final Map<String, Integer> symptomesCount;

        TraiteUnClient(Socket client, Map<String, Integer> symptomesCount) {
            this.client = client;
            this.symptomesCount = symptomesCount;
        }

        public void run() {
            try (DataInputStream sockIn = new DataInputStream(client.getInputStream());
                    DataOutputStream sockOut = new DataOutputStream(client.getOutputStream())) {
                while (true) {
                    String symptome = sockIn.readUTF();
                    if (symptome.equals("fin")) {
                        System.out.println("Le client a fermé la connexion.");
                        break;
                    }
                    int count = symptomesCount.getOrDefault(symptome, 0);
                    sockOut.writeInt(count);
                    sockOut.flush();
                }
            } catch (IOException e) {
                System.err.println("Erreur lors du traitement du client : " + e.getMessage());
            } finally {
                try {
                    client.close();
                } catch (IOException e) {
                    // ignore
                }
            }
        }
    }
}