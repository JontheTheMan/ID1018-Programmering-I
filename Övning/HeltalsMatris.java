import java.util.*;

class HeltalsMatris
{
	public static void main(String[] args)
	{
		System.out.println ("EN HELTALSMATRIS\n\n");

		Scanner in = new Scanner(System.in);
		in.useLocale(Locale.US);

		//Frågar efter matrisens storlek
		System.out.print("Antal tal per rad: ");
		int width = in.nextInt();
		in.nextLine();
		System.out.println();

		System.out.print("Antal rader: ");
				int rows = in.nextInt();
				in.nextLine();
		System.out.println();

		//Matar in matrisen
		System.out.println("Mata in " + (width*rows) + " tal, " + width + " tal per rad: ");

		int[][] matris = new int[rows][width];

		for(int i = 0; i < rows; i++)
			for(int j = 0; j < width; j++)
			{
				matris[i][j] = in.nextInt();
			}

		in.nextLine();
		System.out.println();


		//Beräknar min, max, summa och medelvärde per rad
		int[] max = new int[rows];
		int[] min = new int[rows];
		int[] sum = new int[rows];
		double[] mean = new double[rows];

		for(int i = 0; i < rows; i++)
		{
			max[i] = matris[i][0];
			min[i] = matris[i][0];
			sum[i] = matris[i][0];

			for(int j = 1; j < width; j++)
			{
				if(matris[i][j] > max[i])
					max[i] = matris[i][j];

				else if(matris[i][j] < min[i])
					min[i] = matris[i][j];

				sum[i] += matris[i][j];
			}

			mean[i] = (double)sum[i]/rows;
		}

		//Presenterar resultatet
		System.out.println("Data radvis:");
		System.out.println("|min\t|max\t|summa\t|medelvärde|");

		for(int i = 0; i < rows; i++)
		{
			System.out.println("|" + min[i] + "\t|" + max[i] + "\t|" + sum[i] + "\t|" + mean[i]);
		}
	}
}