package models.pieces;

import models.SquareModel;
import models.ColorEnum;

public abstract class PieceModel implements PieceInterface {

    private ColorEnum color;
    private SquareModel square;

    public PieceModel(ColorEnum color, SquareModel square) {
        this.color = color;
        this.setSquare(square);
    }

    public ColorEnum getColor() {
        return this.color;
    }

    public void setSquare(SquareModel square) {
        this.square = square;
        
        if (square.getPiece() == null) {
            square.setPiece(this);
        }
        else if (square.getPiece() != this) {
            // TODO create a new Exception
            throw new RuntimeException("Invalid set to piece");
        }
        else if (square.getPiece() == this) {
            // TODO create a new Exception
            throw new RuntimeException("Piece already setted");
        }
    }

    public SquareModel getSquare() {
        return this.square;
    }

}
