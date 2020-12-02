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
            piece.column = column;
            piece.row = row;
        }

        public Chesspiece take() {
            piece.moveOut();
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

        public boolean havePiece() {
            return piece != null;
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
            for (Field field : colum) {
                sb.append(field);
                sb.append(" ");
            }
            sb.append("\r\n");
        }

        return sb.toString();
    }

    public boolean isValidField(char row, byte column) {

        return column >= FIRST_COLUMN && column <= NUMBER_OF_COLUMNS && row >= FIRST_ROW && row < (FIRST_ROW + NUMBER_OF_ROWS);
    }

    public void selectField(char row, byte column) {

        if (isValidField(row, column)) {
            int r = row - FIRST_ROW;
            int c = column - FIRST_COLUMN;

            if (fields[r][c].havePiece())
                fields[r][c].piece.markReachableFields();
        }
    }

    public void unselecctField(char row, byte column) {

        if (isValidField(row, column)) {
            int r = row - FIRST_ROW;
            int c = column - FIRST_COLUMN;

            if (fields[r][c].havePiece())
                fields[r][c].piece.unmarkReachableFields();
        }
    }

    public void clearBoard()
    {
        for(Field[] colum : fields)
            for(Field field : colum)
                field.take();
    }

    public void placeAt(Chesspiece chesspiece, char row, byte column)
    {
        int r = row - FIRST_ROW;
        int c = column - FIRST_COLUMN;

        fields[r][c].put(chesspiece);
    }

    public  void removeAt(char row, byte column)
    {
        int r = row - FIRST_ROW;
        int c = column - FIRST_COLUMN;

        fields[r][c].take();
    }

    public abstract class Chesspiece {
        protected char color;
        // W - white, B - black
        protected char name;
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
            row = 0;
            column = -1;
        }

        public abstract void markReachableFields();

        public abstract void unmarkReachableFields();

        protected void mark(char row, int col) {
            if (isValidField(row, (byte) col)) {
                int r = row - FIRST_ROW;
                int c = col - FIRST_COLUMN;
                fields[r][c].mark();
            }
        }

        protected void unmark(char row, int col) {
            if (isValidField(row, (byte) col)) {
                int r = row - FIRST_ROW;
                int c = col - FIRST_COLUMN;
                fields[r][c].unmark();
            }
        }
    }

    public class Pawn extends Chesspiece {

        public Pawn(char color) {
            super(color, 'P');
        }

        public void markReachableFields() {

            byte col = (byte) (column + 1);

            if (color == 'B' || color == 'b')
                col = (byte) (column - 1);

            if (Chessboard.this.isValidField(row, col)) {
                int r = row - FIRST_ROW;
                int c = col - FIRST_COLUMN;
                Chessboard.this.fields[r][c].mark();
            }
        }

        public void unmarkReachableFields() {

            byte col = (byte) (column + 1);

            if (color == 'B')
                col = (byte) (column - 1);

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
            //Markerar raden
            for (byte col = 0; col < NUMBER_OF_COLUMNS; col++) {
                int r = this.row - FIRST_ROW;
                Chessboard.this.fields[r][col].mark();
            }

            //Markerar kolumnen
            for (int row = 0; row < NUMBER_OF_COLUMNS; row++) {
                int c = this.column - FIRST_COLUMN;
                Chessboard.this.fields[row][c].mark();
            }

        }

        public void unmarkReachableFields() {
            //Avmarkerar raden
            for (byte col = 0; col < NUMBER_OF_COLUMNS; col++) {
                int r = this.row - FIRST_ROW;
                Chessboard.this.fields[r][col].unmark();
            }

            //Avmarkerar kollumnen
            for (int row = 0; row < NUMBER_OF_COLUMNS; row++) {
                int c = this.column - FIRST_COLUMN;
                Chessboard.this.fields[row][c].unmark();
            }
        }
    }

    public class Knight extends Chesspiece {
        public Knight(char color) {
            super(color, 'N');
        }

        public void markReachableFields() {

            //Möjligt Drag 1
            char markRow = this.row;
            markRow -= 1;
            int markCol = this.column - 2;
            mark(markRow, markCol);

            //Möjligt Drag 2
            markCol += 4;
            mark(markRow, markCol);

            //Möjligt Drag 3
            markRow += 2;
            mark(markRow, markCol);

            //Möjligt Drag 4
            markCol -= 4;
            mark(markRow, markCol);

            //Möjligt Drag 5
            markCol += 1;
            markRow += 1;
            mark(markRow, markCol);

            //Möjligt Drag 6
            markRow -= 4;
            mark(markRow, markCol);

            //Möjligt Drag 7
            markCol += 2;
            mark(markRow, markCol);

            //Möjligt Drag 8
            markRow += 4;
            mark(markRow, markCol);
        }


        public void unmarkReachableFields() {

            //Möjligt Drag 1
            char markRow = this.row;
            markRow -= 1;
            int markCol = this.column - 2;
            unmark(markRow, markCol);

            //Möjligt Drag 2
            markCol += 4;
            unmark(markRow, markCol);

            //Möjligt Drag 3
            markRow += 2;
            unmark(markRow, markCol);

            //Möjligt Drag 4
            markCol -= 4;
            unmark(markRow, markCol);

            //Möjligt Drag 5
            markCol += 1;
            markRow += 1;
            unmark(markRow, markCol);

            //Möjligt Drag 6
            markRow -= 4;
            unmark(markRow, markCol);

            //Möjligt Drag 7
            markCol += 2;
            unmark(markRow, markCol);

            //Möjligt Drag 8
            markRow += 4;
            unmark(markRow, markCol);

        }
    }

    public class Bishop extends Chesspiece {
        public Bishop(char color) {
            super(color, 'B');
        }

        public void markReachableFields() {

            //Uppåt Vänster
            byte markCol = this.column;
            char markRow = this.row;

            while (markCol >= FIRST_COLUMN && markRow >= FIRST_ROW) {
                mark(markRow, markCol);
                markCol--;
                markRow--;
            }

            //Uppåt Höger
            markCol = this.column;
            markRow = this.row;
            while (markCol < (FIRST_COLUMN + NUMBER_OF_COLUMNS) && markRow >= FIRST_ROW) {
                mark(markRow, markCol);
                markCol++;
                markRow--;
            }

            //Nedåt Höger
            markCol = this.column;
            markRow = this.row;
            while (markCol < (FIRST_COLUMN + NUMBER_OF_COLUMNS) && markRow < (FIRST_ROW + NUMBER_OF_ROWS)) {
                mark(markRow, markCol);
                markCol++;
                markRow++;
            }


            //Nedåt Vänster
            markCol = this.column;
            markRow = this.row;
            while (markCol >= FIRST_COLUMN && markRow < (FIRST_ROW + NUMBER_OF_ROWS)) {
                mark(markRow, markCol);
                markCol--;
                markRow++;
            }

        }

        public void unmarkReachableFields() {
            //Uppåt Vänster
            byte markCol = this.column;
            char markRow = this.row;

            while (markCol >= FIRST_COLUMN && markRow >= FIRST_ROW) {
                unmark(markRow, markCol);
                markCol--;
                markRow--;
            }

            //Uppåt Höger
            markCol = this.column;
            markRow = this.row;
            while (markCol < (FIRST_COLUMN + NUMBER_OF_COLUMNS) && markRow >= FIRST_ROW) {
                unmark(markRow, markCol);
                markCol++;
                markRow--;
            }

            //Nedåt Höger
            markCol = this.column;
            markRow = this.row;
            while (markCol < (FIRST_COLUMN + NUMBER_OF_COLUMNS) && markRow < (FIRST_ROW + NUMBER_OF_ROWS)) {
                unmark(markRow, markCol);
                markCol++;
                markRow++;
            }


            //Nedåt Vänster
            markCol = this.column;
            markRow = this.row;
            while (markCol >= FIRST_COLUMN && markRow < (FIRST_ROW + NUMBER_OF_ROWS)) {
                unmark(markRow, markCol);
                markCol--;
                markRow++;
            }
        }
    }

    public class Queen extends Bishop {

        public Queen(char color) {
            super(color);
            name = 'Q';
        }


        public void markReachableFields() {
            super.markReachableFields();
            //Markerar raden
            for (byte col = 0; col < NUMBER_OF_COLUMNS; col++) {
                int r = this.row - FIRST_ROW;
                Chessboard.this.fields[r][col].mark();
            }

            //Markerar kolumnen
            for (int row = 0; row < NUMBER_OF_COLUMNS; row++) {
                int c = this.column - FIRST_COLUMN;
                Chessboard.this.fields[row][c].mark();
            }

        }

        public void unmarkReachableFields() {
            super.unmarkReachableFields();

            //Avmarkerar raden
            for (byte col = 0; col < NUMBER_OF_COLUMNS; col++) {
                int r = this.row - FIRST_ROW;
                Chessboard.this.fields[r][col].unmark();
            }

            //Avmarkerar kolumnen
            for (int row = 0; row < NUMBER_OF_COLUMNS; row++) {
                int c = this.column - FIRST_COLUMN;
                Chessboard.this.fields[row][c].unmark();
            }
        }
    }

    public class King extends Chesspiece {

        public King(char color) {
            super(color, 'K');
        }


        public void markReachableFields() {

            for (int markCol = this.column - 1; markCol <= this.column + 1; markCol++) {

                char markRow = this.row;
                markRow--;
                for (markRow = markRow; markRow <= this.row + 1; markRow++) {
                    mark(markRow, markCol);
                }
            }

        }

        public void unmarkReachableFields() {

            for (int markCol = this.column - 1; markCol <= this.column + 1; markCol++) {

                char markRow = this.row;
                markRow--;
                for (markRow = markRow; markRow <= this.row + 1; markRow++) {
                    unmark(markRow, markCol);
                }
            }
        }
    }
}
