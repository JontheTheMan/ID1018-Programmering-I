import java.util.*;
import java.io.*;

class PersonUppgift
{
	public static void main(String[] args)
	throws Exception
	{
		System.out.println("Spara personuppgifter");
		System.out.println();

		//Inmatningsvariabler
		Scanner in = new Scanner(System.in);

		//Mata in uppgifter
		System.out.print("Födelseår: ");
		int year = in.nextInt();
		in.nextLine();
		System.out.println();

		System.out.print("Namn och efternamn: ");
		String name = in.nextLine();
		System.out.println();


		//Spara uppgifterna i en fil
		PrintWriter writer = new PrintWriter("PersUpp.txt");
		writer.println(name + " : " + year);
		writer.flush();


		System.out.println("Öppna Filen PersUppg.txt");
	}
}