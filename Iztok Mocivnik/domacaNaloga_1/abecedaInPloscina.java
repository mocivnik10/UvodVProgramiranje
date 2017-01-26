import java.util.Calendar;

public class abecedaInPloscina {

    public static void main(String[] args) {
	    // Klic metode izpisAbecedo
        izpisiAbecedo();
        System.out.println("\n");
      // Klic metode izracunajPloscino()
        izracunajPloscino();
        System.out.println("\n");
    }

    // Metoda ki izpise abecedo
    public static void izpisiAbecedo() {
        // tabela s podatkovnim tipom char ter imenom abeceda
        char[] abeceda;

        // doloci dolzino tabelo
        abeceda = new char[25];

        // Slovenska abeceda malih crk:
        abeceda[0] = '\u0061'; abeceda[1] = '\u0062'; abeceda[2] = '\u0063'; abeceda[3] = '\u010D';
        abeceda[4] = '\u0064'; abeceda[5] = '\u0065'; abeceda[6] = '\u0066'; abeceda[7] = '\u0067';
        abeceda[8] = '\u0068'; abeceda[9] = '\u0069'; abeceda[10] = '\u006A'; abeceda[11] = '\u006B';
        abeceda[12] = '\u006C'; abeceda[13] = '\u006D'; abeceda[14] = '\u006E'; abeceda[15] = '\u006F';
        abeceda[16] = '\u0070'; abeceda[17] = '\u0072'; abeceda[18] = '\u0073'; abeceda[19] = '\u0161';
        abeceda[20] = '\u0074'; abeceda[21] = '\u0075'; abeceda[22] = '\u0076'; abeceda[23] = '\u007A';
        abeceda[24] = '\u017E';

        // 1. Nacin ki bi lahko izpisal crke abecede v 3 stolpcih
        // System.out.println(abeceda[0] + "\t" + abeceda[1] + "\t" + abeceda[2]);
        // System.out.println(abeceda[3] + "\t" + abeceda[4] + "\t" + abeceda[5]);

        System.out.println("Slovenska abeceda: " + "\n");
        int i = 0;
        while (i <=24 ) {
            // Izpisi crko ki se nahaja na trenutnem indexu i ter dodaj tabulator
            System.out.print(abeceda[i] + "\t");
            // za vsako tretjo zapisano crko - naredi novo vrstico:
            if (i == 2 || i == 5 || i == 8 || i == 11 || i == 14 || i == 17 || i == 20 || i == 23)
                System.out.print("\n");
            // pristej index
            i++;
            // Koncaj while zanko ko bo index i vecji kot 24
        }
    }
    // Metoda ki izracuna ploscino
    public static void izracunajPloscino() {
        // Nastavi leto in mesec rojstva
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, 1992);
        calendar.set(Calendar.MONTH, Calendar.JANUARY);
        // v spremenljivko stDni shrani st dni v mesecu januarju
        int stDni = calendar.getActualMaximum(Calendar.DATE);
        // izracunaj ploscino
        double r = stDni;
        double ploscina = Math.PI*r*r;
        System.out.println("Ploščina kroga za mesec JANUAR je: " + ploscina);
    }
}
