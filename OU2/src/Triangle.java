public class Triangle {
    //Metoden tar emot basen och höjden i en triangel och retunerar triangelns area
    public static double area(double base, double height) {
        return base * height / 2;
    }

    //Metoden tar emot tre sidor i en triangel och retunerar omkretsena av triangeln
    public static double circumference(double side1, double side2, double side3) {
        return side1 + side2 + side3;
    }

    //Metoden tar emot två sidor av en triangel och vinkeln mellan dom
    //Metoden retunerar längden av bisektorn mellan sidorna
    public static double bisectorLength(double side1, double side2, double angle) {
        return ((2 * side1 * side2) * Math.cos(angle / 2)) / (side1 + side2);
    }

    //Metoden tar emot en array av längerna av sidorna i en trianglen och en array med vinklarna
    //Metoden retunerar en array med längderna av alla bisektorer
//    public static double[] bisectorsLenghts(double[] sides, double[] angles)
//    {
//        double[] bisects = new double[3];
//
//        bisects[0] = bisectorLength(sides[0], sides[1], angles[2]);
//        bisects[1] = bisectorLength(sides[1], sides[2], angles[1]);
//        bisects[2] = bisectorLength(sides[0], sides[2], angles[0]);
//
//        return  bisects;
//    }


    //Metoden tar emot en längerna på sidorna i en triangel
    //och retunerar sedan radien av cirkeln som är omskriven runt triangeln
    public static double outerCircle(double sideA, double sideB, double sideC)
    {
        //formel ifrån https://sv.wikipedia.org/wiki/Triangel

        //semipermetern
        double s = circumference(sideA, sideB, sideC) / 2;

        //täljare och nämnare i formel
        double t = sideA * sideB * sideC;
        double n = 4 * Math.sqrt(s * (s - sideA) * (s - sideB) * (s - sideC));

        return t / n;
    }

    //Metoden tar emot en längerna på sidorna i en triangel
    //och retunerar sedan radien av cirkeln som är inskriven i triangeln
    public static double innerCircle(double sideA, double sideB, double sideC)
    {
        //formel ifrån https://sv.wikipedia.org/wiki/Triangel

        //semipermetern
        double s = circumference(sideA, sideB, sideC) / 2;
        double t = (s - sideA) * (s - sideB) * (s - sideC);

        return  Math.sqrt(t/s);
    }
}
