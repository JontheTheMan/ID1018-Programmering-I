import java.util.*;


class HeltalsSekvens
{
	public static void main (String[] args)
	{
		System.out.println("En sekvens med heltal");
		System.out.println();


		//Inmatningsvariabler
		Scanner in = new Scanner(System.in);

		//Mata in data
		System.out.print("Hur många tal vil du mata in: ");
		int[] tal = new int[in.nextInt()];
		in.nextLine();

		System.out.println();

		System.out.println("Mata in " + tal.length +" heltal i en rad");

		for(int i = 0; i < tal.length; i++)
		{
			tal[i] = in.nextInt();
		}
		System.out.println();

		//Hittar det störta talet, minsta talet, summan av talen, och medelvärden
		int min = tal[0];
		int max = tal[0];
		int sum = tal[0];

		for(int i = 1; i < tal.length; i++)
		{
			if(max < tal[i])
				max = tal[i];

			else if(min > tal[i])
				min = tal[i];

			sum += tal[i];
		}

		double mean = (double)sum/tal.length;

		//Visa resultat

		System.out.println("Största talet: " + max);
		System.out.println("Minsta talet: " + min);
		System.out.println("Summan av talen: " + sum);
		System.out.println("Medelvärdet av talen: " + mean);

	}
}