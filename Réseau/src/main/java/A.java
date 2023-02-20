import java.io.*;

public class A {
	public static void main(String[] args) throws IOException {
 
		File inputFile = new File("./src/TP1/test1.txt");
		File outputFile = new File("./src/TP1/test2.txt");
		FileReader in = new FileReader(inputFile);
		FileWriter out = new FileWriter(outputFile, true);
		int c;
		
		while ((c = in.read()) != -1) 
			out.write(c);

		in.close();
		out.close();
	}
}
