import  java.util.*;

public class Temperaturer
{
    public static void main(String[] args)
    {
        System.out.println ("TEMPERATURER\n");

        // inmatningsverktyg
        Scanner in = new Scanner (System.in);
        in.useLocale (Locale.US);

        // mata in uppgifter om antalet veckor och antalet mätningar
        System.out.print ("antalet veckor: ");
        int antalVeckor = in.nextInt ();
        System.out.print ("antalet mätningar per vecka: ");
        int antalMatningarPerVecka = in.nextInt ();


        // plats att lagra temperaturer
        double[][] t = new double[antalVeckor + 1][antalMatningarPerVecka + 1];

        // mata in temperaturerna
        for (int vecka = 1; vecka <= antalVeckor; vecka++)
        {
            System.out.println ("temperaturer - vecka " + vecka + ":");
            for (int matning = 1; matning <= antalMatningarPerVecka; matning++)
                t[vecka][matning] = in.nextDouble ();
        }
        System.out.println ();


        // visa temperaturerna
        System.out.println ("temperaturerna:");
        for (int vecka = 1; vecka <= antalVeckor; vecka++)
        {
            for (int matning = 1; matning <= antalMatningarPerVecka; matning++)
                System.out.print (t[vecka][matning] + " ");
            System.out.println ();
        }
        System.out.println ();


        // den minsta, den största och medeltemperaturen – veckovis
        double[] minT = new double[antalVeckor + 1];
        double[] maxT = new double[antalVeckor + 1];

        double[] sumT = new double[antalVeckor + 1];
        double[] medT = new double[antalVeckor + 1];


        // koden ska skrivas här
        // visa den minsta, den största och medeltemperaturen för varje vecka
        //------------------------------------------------------------------

        System.out.println();
        System.out.println("Beräkningar per vecka: ");

        //Loopar veckorna
        for(int i = 1; i <= antalVeckor;i++)
        {
            //Första inmatningen i veckan
            minT[i] = t[i][1];
            maxT[i] = t[i][1];

            sumT[i] = t[i][1];

            //Loopar resten av inmatningarna i veckan
            for (int j = 2; j <= antalMatningarPerVecka; j++)
            {
                //Veckans Max
                if (t[i][j] > maxT[i])
                    maxT[i] = t[i][j];

                //Veckans min
                else  if(t[i][j] < minT[i])
                    minT[i] = t[i][j];

                //Ökar summan
                sumT[i] += t[i][j];
            }

            //Beräknar medelvärde
            medT[i] = sumT[i]/antalMatningarPerVecka;

        }

        //Skriver ut alla resultat
        System.out.println("-------------------------------------------------------------------------");
        for(int i = 1; i <= antalVeckor;i++)
        {
            //Skriver ut resultatet
            System.out.println("Vecka: " + i + "\t| MinT: " + minT[i] + "\t| MaxT: " + maxT[i]
                                + "\t| SumT: " + sumT[i] + "\t| MedT: " + medT[i]);
            System.out.println("-------------------------------------------------------------------------");
        }
        System.out.println();

        System.out.println("Beräkningar hela perioden: ");
        // koden ska skrivas här
        // den minsta, den största och medeltemperaturen - hela mätperioden
        double minTemp = minT[1];
        double maxTemp = maxT[1];
        double sumTemp = sumT[1];

        // koden ska skrivas här
        // visa den minsta, den största och medeltemperaturen i hela mätperioden
        // koden ska skrivas här

        //Resten av veckorna
        for(int i = 2; i <= antalVeckor; i++)
        {
            //Totala min
            if(minT[i] < minTemp)
                minTemp = minT[i];

            //Totala max
            if(maxT[i] > maxTemp)
                maxTemp = maxT[i];

            //Ökar på totala summan
            sumTemp += sumT[i];
        }

        //Beräknar medeltemperaturen
        double medelTemp = sumTemp / (antalMatningarPerVecka * antalVeckor);

        //Skriver ut resultat
        System.out.println("minTemp: " + minTemp);
        System.out.println("maxTemp: " + maxTemp);
        System.out.println("sumTemp: " + sumTemp);
        System.out.println("medTemp: " + medelTemp);

    }
}
