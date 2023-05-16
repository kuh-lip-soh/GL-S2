import java.io.*;

import java.util.*;

public class A {

public static void main(String args[]) throws IOException {

HashMap<String, Integer> map = new HashMap<>();

try (Scanner a = new Scanner(new File("./src/symptomes.txt"))) {

while (a.hasNextLine()) ajouter(map, a.nextLine());

}

}

static void ajouter(Map<String, Integer> map, String symptome) {

// compute() prend en paramètre une clé (symptome dans ce cas),

// ainsi qu'une fonction à appliquer sur la clé et la valeur correspondante

// (la fonction lambda (key, value) -> (value == null) ? 1 : value + 1) dans ce cas)

map.compute(symptome, (key, value) -> (value == null) ? 1 : value + 1);

}

}