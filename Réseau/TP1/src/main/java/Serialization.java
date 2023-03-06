import java.io.*;
public class Serialization {
	public static void main(String[] args) {
		Employee emp = new Employee();
		emp.nom = "BENMAMMAR";
        emp.prenom = "BADR";
		emp.adresse = "TLEMCEN"; 
		emp.affiliation = "UABT";
		try {     
			FileOutputStream fileOut = new FileOutputStream("./src/TP1/employee.txt");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(emp);
			out.close();
			fileOut.close();
			System.out.printf("Serialisation dans ./employee.txt");
		} catch (IOException i) {i.printStackTrace();}
	}
}
