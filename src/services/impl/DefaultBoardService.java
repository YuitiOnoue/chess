package services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import constants.ChessConstants;
import exceptions.ChessException;
import exceptions.parsemove.InvalidMoveException;
import models.BoardModel;
import models.ColorEnum;
import models.SquareModel;
import models.pieces.PieceModel;
import services.BoardService;

public class DefaultBoardService implements BoardService {

    @Override
    public void validateBoard(BoardModel board) throws ChessException {
        if (board == null) {
            throw new ChessException("Null board");
        }
        if (board.getSquares() == null) {
            throw new ChessException("Board not instanciated");
        }
        if (board.getSquares().length != ChessConstants.BOARD_SIZE) {
            throw new ChessException("Invalid board size");
        }
    }

    @Override
    public List<PieceModel> getPieces(BoardModel board, ColorEnum color, Class<? extends PieceModel> pieceClass)
            throws ChessException {
        validateBoard(board);

        List<PieceModel> piecesFound = new ArrayList<>();

        for (int rank = 0; rank < ChessConstants.BOARD_SIZE; rank++) {
            for (int file = 0; file < ChessConstants.BOARD_SIZE; file++) {
                //if (board.getSquare(rank, file).getPiece().getClass().equals(pieceClass)) {
                PieceModel piece = board.getPiece(rank, file);
                
                if (pieceClass.isInstance(piece) && piece.getColor().equals(color)) {
                    piecesFound.add(piece);
                }
            }
        }

        return piecesFound;
    }

    @Override
    public PieceModel getPieceAbleToMoveToSquare(BoardModel board, ColorEnum color,
            Class<? extends PieceModel> pieceClass, SquareModel targetSquare) throws ChessException {

        List<PieceModel> piecesFound = getPieces(board, color, pieceClass);

        return getPieceAbleToMoveToSquare(piecesFound, targetSquare);
    }

    @Override
    public PieceModel getPieceAbleToMoveToSquare(List<PieceModel> pieces, SquareModel targetSquare)
            throws ChessException {
        if (pieces == null || targetSquare == null) {
            throw new InvalidMoveException("No piece found");
        }

        List<PieceModel> piecesAbleToMove = pieces.stream().filter(p -> p.canMove(targetSquare))
                .collect(Collectors.toList());

        if (piecesAbleToMove.size() == 0) {
            throw new InvalidMoveException("No piece found");
        }
        if (piecesAbleToMove.size() > 1) {
            throw new InvalidMoveException("Ambiguous move found");
        }

        return piecesAbleToMove.get(0);
    }

}
