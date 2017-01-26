public class prastevilo {
  public static void main(String[] args) {
      izpisiPrastevila(-1);
      izpisiPrastevila(1);
      izpisiPrastevila(10);
      izpisiPrastevila(20);
      izpisiPrastevila(50);
  }

  public static void izpisiPrastevila(int n) {
      if (n <= 0) {
          System.out.println("Vnesi število, ki je večje od 0!");
      } else if (n == 1) {
          System.out.println("Po definiciji število 1 ne more biti praštevilo, saj sta oba njegova pozitivna delitelja v bistvu enaka!");
      } else {
          System.out.print("Praštevila od 1 do " + n + " so: (");
          for (int i = 2; i <= n; i++) {
              boolean prastevilo = true;

              for (int j = 2; j < i; j++) {
                  if (i % j == 0) {
                      prastevilo = false;
                  }
              }
              if (prastevilo) {
                  System.out.print(i + ", ");
              }
          }
          System.out.println(")");
      }
  }
}
