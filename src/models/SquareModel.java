package models;

import constants.ChessConstants;
import models.pieces.PieceInterface;

public class SquareModel {

    int rank;
    FileEnum file;
    PieceInterface piece;

    public SquareModel(int rank, FileEnum file, PieceInterface piece) {
        this.rank = rank;
        this.file = file;
        this.piece = piece;
    }

    public SquareModel(int rank, FileEnum file) {
        this(rank, file, null);
    }

    public int getRank() {
        return rank;
    }

    public FileEnum getFile() {
        return file;
    }

    public PieceInterface getPiece() {
        return piece;
    }

    public void setPiece(PieceInterface piece) {
        this.piece = piece;
    }

    public String toString() {
        if (piece == null) {
            return ChessConstants.EMPTY_CELL;
        }
        return piece.toString();
    }
}
