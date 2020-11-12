import java.util.*;
import static java.lang.System.out;

public class EnTriangelOchDessCirklar
{
    public static void main(String[] args)
    {
        //Inmatiningsverktyg
        Scanner in = new Scanner(System.in);

        double sides[] = new double[3];

        out.print("Mata in tre sidor på en triangel: ");

        //Läser in tre flyttal och rensar inputbuffern
        for(int i = 0; i < 3; i++)
            sides[i] = in.nextDouble();
        in.nextLine();

        //Beräknar radier
        double outerRad = Triangle.outerCircle(sides[0], sides[1], sides[2]);
        double innerRad = Triangle.innerCircle(sides[0], sides[1], sides[2]);


        out.println("Radien av yttre cirkeln: " + outerRad);
        out.println("Radien av innre cirkeln: " + innerRad);

    }

}
