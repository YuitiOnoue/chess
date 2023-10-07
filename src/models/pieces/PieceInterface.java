package models.pieces;

import models.BoardModel;
import models.SquareModel;

public interface PieceInterface {

    boolean canMove(PieceModel piece, SquareModel destiny, BoardModel board);

}
