package models.pieces;

import models.SquareModel;
import models.ColorEnum;

public abstract class PieceModel implements PieceInterface {

    protected ColorEnum color;
    protected SquareModel square;

    public ColorEnum getColor() {
        return this.color;
    }

    public SquareModel getSquare() {
        return this.square;
    }

}
