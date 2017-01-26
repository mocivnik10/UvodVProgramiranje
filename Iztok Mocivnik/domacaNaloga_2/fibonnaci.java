public class fibonnaci {

  public static void main(String[] args) {
    izracunFibonnacijevegaStevila(0);
    izracunFibonnacijevegaStevila(1);
    izracunFibonnacijevegaStevila(2);
    izracunFibonnacijevegaStevila(3);
    izracunFibonnacijevegaStevila(4);
    izracunFibonnacijevegaStevila(5);
  }

  public static void izracunFibonnacijevegaStevila(int n) {
      if (n<1) {
        System.out.println("Izračun je možen samo za števila večja od 0");
        return;
      }

      System.out.print("Fibonnacijeva števila (" + n + "): ");
      int prvoStevilo = 1;
      int drugoStevilo = 1;
      int trenutnoStevilo = 0;
      int vsota = 0;
      for (int i = 1; i <= n; i++) {
          if (i <= 2) {
              trenutnoStevilo = 1;
          } else {
              trenutnoStevilo += prvoStevilo;
              prvoStevilo = drugoStevilo;
              drugoStevilo = trenutnoStevilo;
          }
          vsota += trenutnoStevilo;
          System.out.print(trenutnoStevilo + " ");
      }
      System.out.println("| Vsota: " + vsota);
    }
}
