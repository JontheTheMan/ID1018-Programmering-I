import java.io.PrintWriter;

public class Test {


    public static void main(String[] args)
    {
        PrintWriter out = new PrintWriter(System.out, true);

        Chessboard board = new Chessboard();

        out.println("Spelplanen");
        out.println(board);

        out.println("Markera spelpjäsens möjliga drag");
        board.selectField('d', (byte)4);
        out.println(board);

        out.println("Avmarkera spelpjäsens möjliga drag");
        board.unselecctField('d', (byte)4);
        out.println(board);

    }
}
