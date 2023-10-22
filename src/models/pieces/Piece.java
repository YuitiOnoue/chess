package models.pieces;

import exceptions.ChessException;
import models.SquareModel;

public interface Piece {

    boolean canMove(SquareModel targetSquare);

    boolean canCapture(SquareModel targetSquare);

    void move(SquareModel targetSquare) throws ChessException;

}
