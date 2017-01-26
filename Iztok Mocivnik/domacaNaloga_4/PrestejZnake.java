import java.util.*;

public class PrestejZnake {

    public static void main(String[] args) {
        String besedilo = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.";
//        besedilo = "rrr aa, b";


        char znak;
        ArrayList<String> listaZnakov = new ArrayList<String>();
        int stZnakov = 0;
        int zadnjiIndex = 0;

        // Z for zanko pojdi cez vse znake v stringu besedilu
        for (int i = 0; i < besedilo.length(); i++) {
            // v spremenljivko znak pripisi malo crko, ki se nahaja na indexu i
            znak = Character.toLowerCase(besedilo.charAt(i));
            // Preveri ce lista ze vsebuje znak - in ce potem nadaljuj zanko od zacetka
            if (listaZnakov.contains(Character.toString(znak))) {
                continue;
            } else {
                // ce se znak ne obstaja pojdi se enkrat cez string besedilo;
                // ter za vse enake znake pristej stZnakov +1 in shrani zadnjiIndex
                for (int j = 0; j < besedilo.length(); j++) {
                    if (znak == Character.toLowerCase(besedilo.charAt(j))) {
                        stZnakov++;
                        zadnjiIndex = j;
                    }
                }
                // Izpisi stevilo enakih znakov + zadnji index na katerem se znak nahaja
                System.out.println("Stevilo '" + znak + "' v besedilu: " + stZnakov + " in zadnji index kjer se nahaja: " + zadnjiIndex);
            }
            // inicializiraj st znakov spet na 0, in dodaj znak v listo
            stZnakov = 0;
            listaZnakov.add(Character.toString(znak));
        }
    }
}
