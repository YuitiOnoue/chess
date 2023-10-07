package models.pieces;

import models.BoardModel;
import models.ColorEnum;
import models.SquareModel;

public class PawnModel extends PieceModel{
    

    public PawnModel(ColorEnum color, SquareModel square) {
        super(color, square);
    }

    @Override
    public boolean canMove(PieceModel piece, SquareModel destiny, BoardModel board) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'canMove'");
    }

    @Override
    public String toString() {
        return this.getColor().toString() + this.getSquare().getFile().toString();
    }
    
}
