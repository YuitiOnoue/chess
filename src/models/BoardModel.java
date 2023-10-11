package models;

import constants.ChessConstants;
import exceptions.ChessException;
import models.pieces.PieceModel;

public class BoardModel {

    private SquareModel[][] squares;

    public BoardModel(SquareModel[][] squares) {
        this.squares = squares;
    }

    public SquareModel[][] getSquares() {
        return this.squares;
    }

    public SquareModel getSquare(int rankIndex, int fileIndex) throws ChessException {
        if (this.squares == null) {
            return null;
        }

        if (rankIndex < 0 || rankIndex > this.squares.length) {
            throw new ChessException("Invalid rank index");
        }

        if (fileIndex < 0 || fileIndex > this.squares[rankIndex].length) {
            throw new ChessException("Invalid file index");
        }

        return squares[rankIndex][fileIndex];
    }

    public SquareModel getSquare(int rank, FileEnum file) throws ChessException {
        if (file == null) {
            throw new ChessException("File can't be null");
        }

        return this.getSquare(rank - 1, file.ordinal());
    }

    public SquareModel getSquare(String squareString) throws ChessException {
        if (squareString == null || squareString.length() != 2
                || !(squareString.matches(ChessConstants.SQUARE_REGEX))) {
            throw new ChessException("Square string invalid");
        }

        FileEnum file = FileEnum.valueOf(squareString.toUpperCase().substring(0, 1));
        int rank = Integer.parseInt(squareString.substring(1, 2));

        return getSquare(rank, file);
    }

    public PieceModel getPiece(int rankIndex, int fileIndex) throws ChessException {
        SquareModel square = getSquare(rankIndex, fileIndex);

        if (square == null) {
            return null;
        }
        return square.getPiece();
    }

}
