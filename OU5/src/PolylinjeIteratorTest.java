import java.io.PrintWriter;

public class PolylinjeIteratorTest {

    public static void main(String[] args) {
        PrintWriter out = new PrintWriter(System.out, true);

        out.println("POLYLINJE ITERATOR TEST:");
        out.println();

        //Utnytrtjar slumpgenererade polylinje ifrån valjpolylinje
        Polylinje linje = ValjPolylinje.slumpPolylinje();

        Polylinje.PolylinjeIterator linjeIterator = linje.new PolylinjeIterator();

        out.println("Linje: " + linje);
        out.println("Linjens hörn: ");

        while (linjeIterator.finnsHorn()) {
            out.println(linjeIterator.horn());
            linjeIterator.gaFram();
        }

    }
}
