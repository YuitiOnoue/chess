package services;

import java.util.List;

import exceptions.ChessException;
import models.BoardModel;
import models.ColorEnum;
import models.SquareModel;
import models.pieces.PieceModel;

public interface BoardService {

    void validateBoard(BoardModel board) throws ChessException;

    List<PieceModel> getPieces(BoardModel board, ColorEnum color, Class<? extends PieceModel> pieceClass)
            throws ChessException;

    PieceModel getPieceAbleToMoveToSquare(BoardModel board, ColorEnum color, Class<? extends PieceModel> pieceClass,
            SquareModel targetSquare) throws ChessException;

    PieceModel getPieceAbleToMoveToSquare(List<PieceModel> pieces, SquareModel targetSquare)
            throws ChessException;

}
