import java.io.*;
public class B {
	
public static void main(String[ ] args)  {
     File fichier= new File("./src/TP1/test1.txt");
       try {
         FileWriter flotEcriture = new FileWriter(fichier);
         for (int i=48; i<=57;i++)
        	 flotEcriture.write(i);
         flotEcriture.close();
       } catch (IOException e) { }    
       }
}
