import java.io.*;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class ObrniNiz {

    public static void main(String[] args) throws IOException {
        FileReader fr = new FileReader("a.txt");
        BufferedReader datA = new BufferedReader(fr);

        FileWriter fw = new FileWriter("b.txt");
        PrintWriter datB = new PrintWriter(fw);

        while (datA.ready()) {
            String vrstica = datA.readLine();
            datB.println(obrniNiz(vrstica));
            System.out.println(obrniNiz(vrstica));
        }
        datB.close();
        datA.close();
    }

    public static String obrniNiz(String niz) {
        int i = niz.length()-1;
        ArrayList<Character> listaZnakov = new ArrayList<Character>();
        while (i>=0) {
            char znak = niz.charAt(i);
            listaZnakov.add(znak);
            i--;
        }
        // Spremeni listaZnakov v string (http://stackoverflow.com/questions/599161/best-way-to-convert-an-arraylist-to-a-string)
        String obrnjenNiz = listaZnakov.stream().map(Object::toString).collect(Collectors.joining(""));
        // Vrni obrnjen niz v malih crkah
        return obrnjenNiz.toLowerCase();
    }
}
