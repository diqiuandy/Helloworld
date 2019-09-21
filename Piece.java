/**
 * Piece class represent the X and O pieces that the players will use
 */
class Piece {
    private String color;

    /**
     * constructor
     *
     * @param c instance variable color
     */
    Piece(String c) {
        this.color = c;
    }

    /**
     * @return Piece's color
     */
    String getColor() {
        return color;
    }
}