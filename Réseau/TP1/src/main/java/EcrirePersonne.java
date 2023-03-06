import java.io.*;
public class EcrirePersonne {
	public static void main(String[] args) {
		Personne p = new Personne();
		p.nom = "BENMAMMAR";
        p.prenom = "BADR";
		p.age = 45; 
		
		Personne e = new Personne();
		e.nom = "BEHLOULI";
        e.prenom = "ZOUBIR";
		e.age = 12; 
		
		try {     
			FileOutputStream fileOut = new FileOutputStream("./src/TP1/Personne.txt");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(p);
			out.writeObject(e);
			out.close();
			fileOut.close();
			System.out.printf("Serialisation dans Personne.txt");
		} catch (IOException i) {i.printStackTrace();}
	}
}
