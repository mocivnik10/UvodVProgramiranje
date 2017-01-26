/*
 *	Razred Avto opisuje nekaj lastnosti in funkcionalnosti avtomobila
 */
import java.io.*;

public class Avto
{
	// Polja
	// Dodana polja: Znamka in barva
	private String znamka;
	private String barva;
	
	private int prestava;
	private double hitrost;
	private String registracija;


	// Konstruktorji:
	// Imajo enako ime kot razred,
	// izvedejo se ob uporabi kljucne besede new.
	// Uporabljamo jih za zacetne nastavitve stanj objektov
	public Avto()
	{
		this.znamka = "Audi";
		this.barva = "Neznana";
		this.prestava = 1;
		this.hitrost = 0;
		this.registracija = "Neznana";
	}

	public Avto(String znamka, String barva, int zacPrestava, double zacHitrost, String zacRegistracija)
	{
		this.znamka = znamka;
		this.barva = barva;
		this.prestava = zacPrestava;
		this.hitrost = zacHitrost;
		this.registracija = zacRegistracija;
	}

	public Avto(String zacRegistracija)
	{
		this.prestava = 1;
		this.hitrost = 0.0;
		this.registracija = zacRegistracija;
	}


	// Metode

	// Metode tipa get nam vrnejo vrednosti polj
	public String getZnamka()
	{
		return this.znamka;
	}

	public String getBarva()
	{
		return this.barva;
	}

	public int getPrestava()
	{
		return this.prestava;
	}

	public double getHitrost()
	{
		return this.hitrost;
	}

	public String getRegistracija()
	{
		return this.registracija;
	}

	// Metode tipa set spremenijo vrednost polja
	public void setRegistracija(String novaRegistracija)
	{
		this.registracija = novaRegistracija;
	}

	public void setZnamka(String novaZnamka)
	{
		this.znamka = novaZnamka;
	}

	public void setBarva(String novaBarva)
	{
		this.barva = novaBarva;
	}

	public void pospesi(double pospesek)
	{
		if(this.hitrost + pospesek > 180)
		{
			System.out.println("Opa, tole bo pa prehitro zame!");
			return;
		}

		this.hitrost += pospesek;

		if(this.hitrost < 20)
		{
			this.prestava = 1;
		}
		else if(this.hitrost < 40)
		{
			this.prestava = 2;
		}
		else if(this.hitrost < 60)
		{
			this.prestava = 3;
		}
		else if(this.hitrost < 90)
		{
			this.prestava = 4;
		}
		else
		{
			this.prestava = 5;
		}
	}

	public void izpisiPodatke()
	{
		System.out.println("***   Podatki   ***");
		System.out.println("Znamka: " + this.getZnamka() + ".");
		System.out.println("Barva: " + this.getBarva() + ".");
		System.out.println("Prestava: " + this.getPrestava() + ".");
		System.out.println("Hitrost: " + this.getHitrost() + " km/h");
		System.out.println("Registracija: " + this.getRegistracija());
		System.out.println();
	}

	// Izvajanje programa
	public static void main(String[] args) throws IOException
	{
		// Naredimo konstruktorja dveh avtomobilov
		Avto nasAvto = new Avto();
		Avto sosedovAvto = new Avto("BMW", "Crna", 5, 130, "NM-XY-001");

		// Izpisimo podatke
		nasAvto.izpisiPodatke();
		sosedovAvto.izpisiPodatke();

		
		// Upravljajmo z njima
		nasAvto.pospesi(30);
		nasAvto.setBarva("Zelena");
		nasAvto.setRegistracija("Ce-000776");
		nasAvto.izpisiPodatke();
		


		/*
		InputStreamReader inStream = new InputStreamReader(System.in);
		BufferedReader bfr = new BufferedReader(inStream);
		while(nasAvto.getHitrost() < 240)
		{
			System.out.print("Vnesite pospesek nasega avta: ");
			int novaHitrost = Integer.parseInt(bfr.readLine());
			nasAvto.pospesi(novaHitrost);
			System.out.println();
			nasAvto.izpisiPodatke();
		}
		System.out.print("Pretiravati ne smemo.");
		*/
	}
}