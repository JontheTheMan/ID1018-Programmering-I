import java.io.*; // PrintWriter

public class PolylinjeTest {

    public static void main(String[] args) {
        PrintWriter out = new PrintWriter(System.out, true);

        out.println("POLYLIJE TEST:");
        out.println();

        //Testar tom konstruktor
        Polylinje linje = new Polylinje();
        out.println("Linje: " + linje);
        out.println();

        //Testar konstruktor
        linje = new Polylinje(new Punkt[]{
                new Punkt("A", 3, 4),
                new Punkt("B", 5, 4),
                new Punkt("C", 6, 4)});

        out.println("Linje: " + linje);
        out.println();

        //Testar copykonstruktor
        Polylinje linjeCopy = new Polylinje(linje);
        out.println("Linje Kopia: " + linjeCopy);
        linjeCopy.setFarg("Röd");
        linjeCopy.setBredd(5);
        out.println("Ändrar kopian till: " + linjeCopy);
        out.println("Men linjen är fortfarande: " + linje);
        out.println();

        //Testar getHorn()
        Punkt[] hornCopy = linje.getHorn();
        out.println("Hörn kopierade infrån Lijne: ");
        for (Punkt h : hornCopy)
            out.println(h);

        hornCopy[0].setX(1);
        hornCopy[0].setY(5);
        hornCopy[0].setNamn("Annat");
        out.println("Ändrat första hörnet i kopierade listan till: " + hornCopy[0]);

        out.println("Första hörnet i polylinjen är fortfarande " + linje.getHorn()[0]);
        out.println();


        //Testar getFarg()
        String fargCopy = linje.getFarg();
        out.println("Kopierad färg ifrån linje: " + fargCopy);

        fargCopy = "Gul";
        out.println("Ändrat kopierade färgen till " + fargCopy);
        out.println("Men linjens färg är fortfarande " + linje.getFarg());

        //Testar setFarg()
        linje.setFarg(fargCopy);
        out.println("Lijens färg satt till kopian och är nu " + fargCopy);

        fargCopy = "Röd";
        out.println("Ändrat kopierade färgen till " + fargCopy);
        out.println("Men linjens färg är fortfarande " + linje.getFarg());
        out.println();

        //Testar getBredd()
        int breddCopy = linje.getBredd();
        out.println("Kopierad bredd från linjen: " + breddCopy);

        breddCopy = 5;
        out.println("Ändrat kopierade bredden till " + breddCopy);
        out.println("Men linjens bredd är fortfarande " + linje.getBredd());

        //Testar setBredd
        linje.setBredd(breddCopy);
        out.println("Linjens bredd satt till kopians och är nu " + linje.getBredd());

        breddCopy = 3;
        out.println("Ändrat kopierade bredden till " + breddCopy);
        out.println("Men linjens bredd är fortfarande " + linje.getBredd());
        out.println();


        //Testar langd()
        out.println("Polylinjens längd är " + linje.langd());
        out.println();


        //Testar laggTill()
        Punkt p = new Punkt("D", 5, 6);
        linje.laggTill(p);

        out.println("Lagt till punkten " + p + " i linjen");
        out.println("Linjen är nu: " + linje);

        p.setX(1);
        p.setY(1);
        p.setNamn("Q");
        out.println("Ändrat punkten till " + p);
        out.println("Men linjen är fortfarande: " + linje);
        out.println();

        //Testar laggTillFramfor()
        linje.laggTillFramfor(p, "C");
        out.println("Lagt till punkten " + p + " före punkten med namn C");
        out.println("Linjen är nu: " + linje);

        p.setX(2);
        p.setY(5);
        p.setNamn("P");
        out.println("Ändrat punkten till " + p);
        out.println("Men linjen är fortfarande: " + linje);
        out.println();

        //Testar taBort()
        out.println("Tar bort punkten med namn Q");
        linje.taBort("Q");
        out.println("Linjen är nu: " + linje);
    }
}
