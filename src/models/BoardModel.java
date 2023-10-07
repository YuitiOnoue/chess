package models;

public class BoardModel {

    private SquareModel[][] squares;

    public BoardModel(SquareModel[][] squares) {
        this.squares = squares;
    }

    public SquareModel[][] getSquares() {
        return this.squares;
    }
    
}
