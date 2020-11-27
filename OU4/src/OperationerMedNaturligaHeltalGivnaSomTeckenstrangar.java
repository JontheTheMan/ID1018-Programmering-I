import com.sun.jdi.IntegerType;

import java.util.*; // Scanner
import static java.lang.System.out;

class OperationerMedNaturligaHeltalGivnaSomTeckenstrangar
{
    public static void main (String[] args)
    {
        out.println ("OPERATIONER MED NATURLIGA HELTAL GIVNA SOM TECKENSTRANGAR\n");
        // mata in två naturliga heltal

        while(true)
        {
            Scanner in = new Scanner(System.in);
            out.println("två naturliga heltal:");
            String tal1 = in.next();
            String tal2 = in.next();
            out.println();


            // addera heltalen och visa resultatet
            String summa = addera(tal1, tal2);
            visa(tal1, tal2, summa, '+');


            // subtrahera heltalen och visa resultatet
            String differens = subtrahera(tal1, tal2);
            visa(tal1, tal2, differens, '-');
        }
    }

    // addera tar emot två naturliga heltal givna som teckensträngar, och returnerar deras
    // summa som en teckensträng.
    public static String addera (String tal1, String tal2)
    {
        //Längsta talet av tal1 och tal2
        int maxLength = Math.max(tal1.length(), tal2.length());

        char[]  numbers1 = tal1.toCharArray();
        char[]  numbers2 = tal2.toCharArray();

        StringBuilder result = new StringBuilder();
        int carry = 0, n1, n2;
        for(int i = 0; i < maxLength; i++)
        {
            //Hämtar nästa tal ifrån tal1, om vi är över talets längd är det 0
            if(i < numbers1.length)
                n1 = Character.getNumericValue(numbers1[numbers1.length - i - 1]);
            else
                n1 = 0;

            //Hämtar nästa tal ifrån tal1, om vi är över talets längd är det 0
            if(i < numbers2.length)
                n2 = Character.getNumericValue(numbers2[numbers2.length - i - 1]);
            else
                n2 = 0;


            //Adderar talen, adderar entalet och resten, sätter tiotalet till rest
            int addition = n1 + n2 + carry;
            int toAdd = addition % 10;
            carry = addition / 10;

            result.insert(0, toAdd);
        }

        if(carry > 0)
            result.insert(0, carry);

        return result.toString();
    }


    // subtrahera tar emot två naturliga heltal givna som teckensträngar, och returnerar
    // deras differens som en teckensträng.
    // Det första heltalet är inte mindre än det andra heltalet.
    public static String subtrahera (String tal1, String tal2)
    {
        char[]  numbers1 = tal1.toCharArray();
        char[]  numbers2 = tal2.toCharArray();

        StringBuilder result = new StringBuilder();

        int borrow = 0, n1, n2;
        for(int i = 0; i < tal1.length(); i++)
        {
            //Hämtar nästa tal ifrån tal1, om vi är över talets längd är det 0
            if(i < numbers1.length)
                n1 = Character.getNumericValue(numbers1[numbers1.length - i - 1]);
            else
                n1 = 0;

            //Hämtar nästa tal ifrån tal1, om vi är över talets längd är det 0
            if(i < numbers2.length)
                n2 = Character.getNumericValue(numbers2[numbers2.length - i - 1]);
            else
                n2 = 0;

            //Tar bort eventuella lån ifrån första talet
            n1 -= borrow;

            //Utför sutbraktion
            int subtract = n1 - n2;

            //Kollar om vi behöver låna ifrån före
            if(subtract < 0)
            {
                subtract += 10;
                borrow = 1;
            }
            else
                borrow = 0;


            result.insert(0, subtract);
        }

        //Tar bort extra nollor
        while (result.charAt(0) == '0' && result.length() > 1)
            result.deleteCharAt(0);

        return result.toString();
    }


    // visa visar två givna naturliga heltal, och resultatet av en aritmetisk operation
    // utförd i samband med hetalen
    public static void visa (String tal1, String tal2, String resultat, char operator)
    {

        // sätt en lämplig längd på heltalen och resultatet
        int len1 = tal1.length ();
        int len2 = tal2.length ();
        int len = resultat.length ();

        int maxLen = Math.max (Math.max (len1, len2), len);
        tal1 = sattLen (tal1, maxLen - len1);

        tal2 = sattLen (tal2, maxLen - len2);
        resultat = sattLen (resultat, maxLen - len);

        // visa heltalen och resultatet
        out.println (" " + tal1);
        out.println ("" + operator + " " + tal2);

        for (int i = 0; i < maxLen + 2; i++)
            out.print ("-");
        out.println ();

        out.println (" " + resultat + "\n");
    }


    // sattLen lägger till ett angivet antal mellanslag i början av en given sträng
    public static String sattLen (String s, int antal)
    {
        StringBuilder sb = new StringBuilder (s);
        for (int i = 0; i < antal; i++)
            sb.insert (0, " ");
        return sb.toString ();
    }
}
