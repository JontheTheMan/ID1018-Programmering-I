import java.util.Random;

public class EU1
{

    public static void main(String[] args)
    {
        int[] element = new int[]{18, 64, 23, 32, 90, 189, 19, 13, 16, 8, 21, 45, 225, 30, 20, 16, 1, 13, 20};
        Random rnd = new Random();


        int minElement = min(element);
        System.out.println("Minsta elementet är " + minElement);
    }


    // min returnerar det minsta elementet i en sekventiell samling.
    // Om samlingen är tom, kastas ett undantag av typen IllegalArgumentException.
    public static int min(int[] element) throws IllegalArgumentException
    {
        if (element.length == 0)
            throw new IllegalArgumentException("tom samling");



        // hör ihop med spårutskriften 2:
        // int antalVarv = 1;

        int[] sekvens = element;
        int antaletPar = sekvens.length / 2;
        int antaletOparadeElement = sekvens.length % 2;
        int antaletTankbaraElement = antaletPar + antaletOparadeElement;
        int[] delsekvens = new int[antaletTankbaraElement];

        int i = 0;
        int j = 0;

        //spårutskrift 1 – för att följa sekvensen
        System.out.println (java.util.Arrays.toString (sekvens));

        while (sekvens.length > 1)
        {
            // skilj ur en delsekvens med de tänkbara elementen
            i = 0;
            j = 0;
            while (j < antaletPar)
            {
                delsekvens[j++] = (sekvens[i] < sekvens[i + 1]) ? sekvens[i] : sekvens[i + 1];
                i += 2;
            }
            
            if (antaletOparadeElement == 1)
                delsekvens[j] = sekvens[sekvens.length - 1];

            // utgå nu ifrån delsekvensen
            sekvens = delsekvens;
            antaletPar = antaletTankbaraElement / 2;
            antaletOparadeElement = antaletTankbaraElement % 2;
            antaletTankbaraElement = antaletPar + antaletOparadeElement;
            delsekvens = new int[antaletTankbaraElement]; //Lagt till för fel 1


            // spårutskrift 2 - för att avsluta loopen i förväg
            // (för att kunna se vad som händer i början)
            // if (antalVarv++ == 10)
            // System.exit (0);
        }

        // sekvens[0] är det enda återstående tänkbara elementet
        // - det är det minsta elementet
        return sekvens[0];
    }
}
