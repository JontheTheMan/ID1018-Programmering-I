import static java.lang.System.out;
import java.util.*;
public class Main
{
    public  static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);

        bisector(in);
    }

    private static void area(Scanner in)
    {
        out.print("Ange Bas: ");
        double base = in.nextDouble();
        in.nextLine();

        out.print("Ange Höjd: ");
        double height = in.nextDouble();
        in.nextLine();

        out.println("Triangelns area är " + Triangle.area(base, height));
    }

    private static void bisector(Scanner in)
    {
        out.print("Ange två längden på sidorna: ");
        double s1 = in.nextDouble();
        double s2 = in.nextDouble();
        in.nextLine();

        out.print("Ange vinkeln mellan sidorna (radianer): ");
        double angle = in.nextDouble();
        in.nextLine();

        out.println("Längden av bisektrisen är " + Triangle.bisector(s1, s2, angle));
    }


}
