public class DenKortasteVagen
{
    // mellanstationer returnerar en vektor med de mellanstationer som finns på den kortaste
    // vägen. Ordningsnummer av den första mellanstationen finns på index 1, och ordningsnummer
    // av den andra mellanstationen på index 2 i vektorn.
    public static int[] mellanstationer (double[] a, double[][] b, double[] c)
    {
        int[] stationer = new int[] {1,1};
        double dMin = a[1] + b[1][1] + c[1];

        for(int i = 1; i < a.length; i++)
            for(int j = 1; j < b[i].length; j++)
            {
                double d = a[i] + b[i][j] + c[j];

                if(d < dMin)
                {
                    dMin = d;
                    stationer[0] = i;
                    stationer[1] = j;
                }
            }

        return stationer;
    }

    // langd returnerar längden av den kortaste vägen.
    public static double langd (double[] a, double[][] b, double[] c) {
        int[] ms = mellanstationer(a, b, c);

        return a[ms[0]] + b[ms[0]][ms[1]] + c[ms[1]];
    }
}
