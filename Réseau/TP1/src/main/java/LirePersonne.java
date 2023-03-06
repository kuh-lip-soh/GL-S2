import java.io.*;
import java.util.ArrayList;
public class LirePersonne {
	@SuppressWarnings({ "null", "rawtypes" })
	public static void main(String[] args) {

		try {
			FileInputStream fileIn = new FileInputStream("./src/TP1/Personne.txt");
			ObjectInputStream in = new ObjectInputStream(fileIn);
				Object personne = (Personne) in.readObject();
				ArrayList list = (ArrayList) personne;
				for(int i=0;i<list.size();i++)
				{
					Object p = list.get(i);					
					System.out.print(p);
				}
			in.close();fileIn.close();
		} catch (IOException i) {i.printStackTrace();
		} catch (ClassNotFoundException c) {c.printStackTrace();}
		System.out.println("Deserialisation...");
		
	}
}
