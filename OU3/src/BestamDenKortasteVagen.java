import java.util.Scanner;
import  static  java.lang.System.out;
public class BestamDenKortasteVagen
{
    public static void main(String[] args)
    {
        //Inmating
        Scanner in = new Scanner(System.in);

        out.println("-- BESTÄM DEN KORTASTE VÄGEN --");
        out.println();

        //Exempelinstans med förbestämda värden
        exempelInstans();

        //Användaren matar in datan
        inmatadData(in);
    }


    //En exempelinstans av uppgiften OU3 med förbestämda värden
    private static void exempelInstans()
    {
        //Exempelinstans
        out.println("Förbestämt exempelinstans: ");
        double[]    a = new double[]  {0, 2, 4, 3};
        double[][]  b = new double[][]{  {},            //Första platsen i vektorn tom
                                      {0, 4, 5, 1, 3},
                                      {0, 2, 4, 3, 6},
                                      {0, 7, 3, 2, 1}};

        double[]    c = new double[]  {0, 3, 5, 2, 4};

        //Beräkningar
        int[]   stationer = DenKortasteVagen.mellanstationer(a, b, c);
        double  avstand = DenKortasteVagen.langd(a, b, c);

        //Utmatning
        out.println("Kortaste avståndet är " + avstand + " genom U" + stationer[0] + " och V" + stationer[1]);


        out.println("----------------------------------------------------");
        out.println();
    }

    //Användaren matar själv in datan för uppgiften OU3
    private static void inmatadData(Scanner in)
    {
        //Valfri inmating
        out.println("Valfrit Scenario: ");


        //Läser in antalet mellanstationer i zonerna
        out.print("Antal mellanstationer i Z2: ");
        int z2 = in.nextInt();
        in.nextLine();

        out.print("Antal stationer i Z3: ");
        int z3 = in.nextInt();
        in.nextLine();



        //Återanvänder variabler ifrån exemplena
        double[]    a = new double[z2 + 1];
        double[][]  b = new double[z2+1][z3 + 1];
        double[]    c = new double[z3 + 1];

        //Matar in värdena på mellanstationerna
        //Avstånden till stationerna i Z2
        out.print("Ange de " + z2 + " avstånden ifrån start X till stationerna i Z2:  ");

        for(int i = 1; i < a.length; i++)
            a[i] = in.nextDouble();
        in.nextLine();


        //Avståndet till stationerna i Z2 till stationerna i Z3
        for(int i = 1; i < a.length; i++)
        {
            out.print("Ange de " + z3 + " avstånd ifrån U" + i + " i Z2 till stationerna i Z3:  ");

            for(int j = 1; j < b[i].length; j++)
                b[i][j] = in.nextDouble();
            in.nextLine();
        }

        //Avstånden mellan stationerna i Z3 till slutstationen Y
        out.print("Ange de " + z3 + " avstånden ifrån stationerna i Z2 till slutstaionen i Y:  ");
        for(int i = 1; i < c.length; i++)
            c[i] = in.nextDouble();
        in.nextLine();



        //Beräkningar
        int[]   stationer = DenKortasteVagen.mellanstationer(a, b, c);
        double  avstand = DenKortasteVagen.langd(a, b, c);

        //Utmatning
        out.println("Kortaste avståndet är " + avstand + " genom U" + stationer[0] + " och V" + stationer[1]);
    }
}
