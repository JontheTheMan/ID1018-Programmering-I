import java.util.*;

class Kostnad
{
	public static void main(String[] args)
	{
		System.out.println("Beräkna kostnad för böcker");
		System.out.println();

		//Variabler för inmatning
		Scanner in = new Scanner(System.in);
		in.useLocale(Locale.US);

		//Mata in uppgifter
		System.out.print("Antalet böcker: ");
		int antal = in.nextInt();
		in.nextLine();
		System.out.println();

		System.out.print("Pris per bok: ");
		double pris = in.nextDouble();
		in.nextLine();
		System.out.println();


		//Beräkna kostnaden
		double kostnad = pris * antal;

		System.out.println("Total Kostnad: " + kostnad + " kr");

	}
}