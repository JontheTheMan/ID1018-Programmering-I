import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class ReachableFieldsOnChessboard {

    static final Random rnd = new Random();

    public static  void main(String[] args) throws InterruptedException, IOException {
        System.in.read();

        PrintWriter out = new PrintWriter(System.out, true);

        Chessboard chessBoard = new Chessboard ();
        out.println (chessBoard + "\n");
        Chessboard.Chesspiece[] pieces = new Chessboard.Chesspiece[6];
        pieces[0] = chessBoard.new Pawn ('w');
        pieces[1] = chessBoard.new Rook ('b');
        pieces[2] = chessBoard.new Queen ('w');
        pieces[3] = chessBoard.new Bishop ('w');
        pieces[4] = chessBoard.new King ('b');
        pieces[5] = chessBoard.new Knight ('w');


        for(Chessboard.Chesspiece pice : pieces)
        {
            char row = (char)('a' + rnd.nextInt(7));
            byte col = (byte)(1 + rnd.nextInt(7));

            chessBoard.placeAt(pice, row, col);
            chessBoard.selectField(row, col);
            out.println (chessBoard + "\n");

            TimeUnit.SECONDS.sleep(3);

            chessBoard.unselecctField(row, col);
            chessBoard.removeAt(row, col);

        }


    }

}
