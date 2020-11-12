public class Triangle
{
    public static double area(double base, double height)
    {
        return base * height /2;
    }

    public static double circumference(double side1, double side2, double side3)
    {
        return  side1 + side2 + side3;
    }

    public static  double bisector(double side1, double side2, double angle)
    {
        return ((2 * side1 * side2) * Math.cos(angle/2)) / (side1 + side2);
    }

    public static double[] bisectors(double[] sides, double[] angles)
    {
        double[] bisects = new double[3];

        bisects[0] = bisector(sides[0], sides[1], )

        return  bisects;
    }


}
