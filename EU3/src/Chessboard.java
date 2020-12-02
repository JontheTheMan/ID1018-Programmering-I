import java.sql.Struct;

public class Chessboard {

    public static class Field {

        private char row;
        private byte column;
        private Chesspiece piece = null;
        private boolean marked = false;

        public Field(char row, byte column) {
            this.row = row;
            this.column = column;
        }

        public void put(Chesspiece piece) {
            this.piece = piece;
        }

        public Chesspiece take() {
            Chesspiece toReturn = piece;
            piece = null;
            return toReturn;
        }

        public void mark() {
            marked = true;
        }

        public void unmark() {
            marked = false;
        }

        public String toString() {
            String s = (marked) ? "xx" : "--";
            return (piece == null) ? s : piece.toString();
        }
    }
    //----------------------------------------------------------------------

    public static final int NUMBER_OF_ROWS = 8;
    public static final int NUMBER_OF_COLUMNS = 8;
    public static final int FIRST_ROW = 'a';
    public static final int FIRST_COLUMN = 1;
    private Field[][] fields;

    public Chessboard() {
        fields = new Field[NUMBER_OF_ROWS][NUMBER_OF_COLUMNS];
        char row = 0;
        byte column = 0;
        for (int r = 0; r < NUMBER_OF_ROWS; r++) {
            row = (char) (FIRST_ROW + r);
            column = FIRST_COLUMN;
            for (int c = 0; c < NUMBER_OF_COLUMNS; c++) {
                fields[r][c] = new Field(row, column);
                column++;
            }
        }
    }

    public String toString() {

        StringBuilder sb = new StringBuilder();

        for (Field[] colum : fields) {
            for (Field field : colum)
            {
                sb.append(field);
                sb.append(" ");
            }
            sb.append("\r\n");
        }

        return sb.toString();
    }

    public boolean isValidField(char row, byte column) {

        return column > 0 && column <= NUMBER_OF_COLUMNS && row >= FIRST_ROW && row <= (FIRST_ROW + NUMBER_OF_ROWS);
    }


    public abstract class Chesspiece {
        private char color;
        // w - white, b - black
        private char name;
        // K - King, Q - Queen, R - Rook, B - Bishop, N - Knight,
        // P – Pawn
        protected char row = 0;
        protected byte column = -1;

        protected Chesspiece(char color, char name) {
            this.color = color;
            this.name = name;
        }

        public String toString() {
            return "" + color + name;
        }

        public boolean isOnBoard() {
            return Chessboard.this.isValidField(row, column);
        }

        public void moveTo(char row, byte column) throws NotValidFieldException {
            if (!Chessboard.this.isValidField(row, column))
                throw new NotValidFieldException("bad field: " + row + column);
            this.row = row;
            this.column = column;
            int r = row - FIRST_ROW;
            int c = column - FIRST_COLUMN;
            Chessboard.this.fields[r][c].put(this);
        }

        public void moveOut() {
        }

        public abstract void markReachableFields();

        public abstract void unmarkReachableFields();
    }

    public class Pawn extends Chesspiece {

        public Pawn(char color) {
            super(color, 'P');
        }

        public void markReachableFields() {

            byte col = (byte) (column + 1);
            if (Chessboard.this.isValidField(row, col)) {
                int r = row - FIRST_ROW;
                int c = col - FIRST_COLUMN;
                Chessboard.this.fields[r][c].mark();
            }

        }

        public void unmarkReachableFields() {

            byte col = (byte) (column + 1);
            if (Chessboard.this.isValidField(row, col)) {
                int r = row - FIRST_ROW;
                int c = col - FIRST_COLUMN;
                Chessboard.this.fields[r][c].unmark();
            }

        }
    }

    public class Rook extends Chesspiece {
        public Rook(char color) {
            super(color, 'R');
        }


        public void markReachableFields() {

        }

        public void unmarkReachableFields() {

        }
    }

    public class Knight extends Chesspiece {
        public Knight(char color) {
            super(color, 'N');
        }


        public void markReachableFields() {

        }


        public void unmarkReachableFields() {

        }
    }

    public class Bishop extends Chesspiece {
        public Bishop(char color) {
            super(color, 'B');
        }

        public void markReachableFields() {

        }

        public void unmarkReachableFields() {

        }
    }

    public class Queen extends Chesspiece {

        public Queen(char color) {
            super(color, 'Q');
        }


        public void markReachableFields() {

        }

        public void unmarkReachableFields() {

        }
    }

    public class King extends Chesspiece {

        public King(char color) {
            super(color, 'K');
        }


        public void markReachableFields() {

        }

        public void unmarkReachableFields() {

        }
    }
}
