import java.rmi.*;
import java.util.List;
import java.util.Scanner;

public class CarnetClient {
	public static void main(String[] argv) {
		try {
			CarnetInterface carnet = (CarnetInterface) Naming.lookup("rmi://localhost:1099/Carnet");
			Scanner scanner = new Scanner(System.in);
                        
                        Adresse adresse1 = new Adresse("Hamid", 1, "Tlemcen");
                        Adresse adresse2 = new Adresse("Fethallah", 10, "Tlemcen");
                        
                        carnet.enregistrer("Hamid",adresse1);
                        carnet.enregistrer("Fethallah",adresse2);

                        while (true) {
                            System.out.println("\n\nQue voulez-vous faire ?");
                            System.out.println("1 - Enregistrer une adresse");
                            System.out.println("2 - Effacer une adresse");
                            System.out.println("3 - Chercher une adresse");
                            System.out.println("4 - Lister les adresses");
                            System.out.println("5 - Quitter");
                            int choix = scanner.nextInt();

                            switch (choix) {
                                case 1:
                                    System.out.println("Nom : ");
                                    String nom = scanner.next();
                                    System.out.println("Numéro de rue : ");
                                    int rue = scanner.nextInt();
                                    System.out.println("Nom de ville : ");
                                    String ville = scanner.next();
                                    Adresse adresse = new Adresse(nom, rue, ville);
                                    carnet.enregistrer(nom, adresse);
                                break;
                                case 2:
                                    System.out.println("Nom : ");
                                    nom = scanner.next();
                                    adresse = carnet.chercher(nom);
                                    if (adresse != null) {
                                        System.out.println("L'adresse : " + adresse.toString() + " a été éffacé.");
                                        carnet.effacer(nom);
                                    } else {
                                        System.out.println("Adresse introuvable.");
                                    }
                                    
                                break;
                                case 3:
                                    System.out.println("Nom : ");
                                    nom = scanner.next();
                                    adresse = carnet.chercher(nom);
                                    if (adresse != null) {
                                        System.out.println(adresse.toString());
                                    } else {
                                        System.out.println("Adresse introuvable.");
                                    }
                                break;
                                case 4:
                                    List<Adresse> adresses = carnet.lister();
                                    for (Adresse a : adresses) {
                                        System.out.println(a.toString());
                                    }
                                break;
                                case 5:
                                    System.out.println("Au revoir !");
                                    System.exit(0);
                                break;
                                default:
                                    System.out.println("Choix invalide.");
                                break;
                            }
                        }
		} catch(Exception e) {
			System.out.println("Exception: "+e);
		}
	}
}