/**
 * Board class represent the board that the pieces will be placed in.
 */
class Board {
    private Piece[][] board;

    /**
     * Constructor.  Needs to initialize board with '-'
     */
    Board() {
        board = new Piece[6][7];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = new Piece("-");
            }
        }
    }

    /**
     * Prints the board
     */
    void print() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j].getColor() +
                        (j == board[i].length - 1 ? "\n" : " "));
            }
        }
    }

    /**
     * adds a piece to column
     *
     * @param piece
     * @param columnNumber
     * @throws IllegalArgumentException if the column of board is full or columnNumber is not range in [1,7].
     */
    void addPiece(Piece piece, int columnNumber) {
        columnNumber--;
        for (int i = 5; i >= 0; i--) {
            if (board[i][columnNumber].getColor().equals("-")) {
                board[i][columnNumber] = piece;
                return;
            }
        }
    }

    /**
     * tells if the board is full (used in tie condition)
     *
     * @return true if the board is full, otherwise false.
     */
    boolean isFull() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j].getColor().equals("-")) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * checks to see if a winning condition has been met
     *
     * @return true if a winning condition has been met, otherwise false.
     */
    boolean win() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (!board[i][j].getColor().equals("-")) {
                    int flag;
                    if (j < 4) {
                        flag = 0;
                        for (int k = 1; k < 4; k++) {
                            if (board[i][j].getColor().equals(board[i][j + k].getColor())) {
                                flag++;
                            }
                        }
                        if (flag == 3) {
                            return true;
                        }
                    }
                    if (i < 3) {
                        flag = 0;
                        for (int k = 1; k < 4; k++) {
                            if (board[i][j].getColor().equals(board[i + k][j].getColor())) {
                                flag++;
                            }
                        }
                        if (flag == 3) {
                            return true;
                        }
                    }
                    if (i < 3 && j < 4) {
                        flag = 0;
                        for (int k = 1; k < 4; k++) {
                            if (board[i][j].getColor().equals(board[i + k][j + k].getColor())) {
                                flag++;
                            }
                        }
                        if (flag == 3) {
                            return true;
                        }
                    }
                    if (i > 2 && j < 4) {
                        flag = 0;
                        for (int k = 1; k < 4; k++) {
                            if (board[i][j].getColor().equals(board[i - k][j + k].getColor())) {
                                flag++;
                            }
                        }
                        if (flag == 3) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
}