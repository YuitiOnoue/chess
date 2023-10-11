package models.pieces;

import exceptions.ChessException;
import models.ColorEnum;
import models.SquareModel;

public class PawnModel extends PieceModel {

    public PawnModel(ColorEnum color) {
        super(color);
    }

    public PawnModel(ColorEnum color, SquareModel square) {
        super(color, square);
    }

    @Override
    public boolean canMove(SquareModel targetSquare) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'canMove'");
    }

    @Override
    public void move(SquareModel targetSquare) throws ChessException {

        if (canMove(targetSquare)) {
            this.setSquare(targetSquare);
        }

        throw new ChessException("Invalid move");
    }

    @Override
    public String toString() {
        return this.getColor().toString() + this.getSquare().getFile().toString();
    }

}
