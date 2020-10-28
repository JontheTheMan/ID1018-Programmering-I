import java.util.*;

class Kostnad
{
	public static void main(String[] args)
	{
		System.out.println("Ber�kna kostnad f�r b�cker");
		System.out.println();

		//Variabler f�r inmatning
		Scanner in = new Scanner(System.in);
		in.useLocale(Locale.US);

		//Mata in uppgifter
		System.out.print("Antalet b�cker: ");
		int antal = in.nextInt();
		in.nextLine();
		System.out.println();

		System.out.print("Pris per bok: ");
		double pris = in.nextDouble();
		in.nextLine();
		System.out.println();


		//Ber�kna kostnaden
		double kostnad = pris * antal;

		System.out.println("Total Kostnad: " + kostnad + " kr");

	}
}