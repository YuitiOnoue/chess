package models;

import constants.ChessConstants;
import models.pieces.PieceModel;

public class SquareModel {

    int rank;
    FileEnum file;
    PieceModel piece;

    public SquareModel(int rank, FileEnum file, PieceModel piece) {
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

    public PieceModel getPiece() {
        return piece;
    }

    public void setPiece(PieceModel piece) {
        if (this.piece == null) {
            this.piece = piece;
        } else if (this.piece != piece) {
            // TODO create a new Exception
            throw new RuntimeException("Invalid set piece");
        } else if (this.piece == piece) {
            // TODO create a new Exception
            throw new RuntimeException("Piece already setted");
        }
    }

    public String getSquareName() {
        return file.toString() + rank;
    }

    public String getPieceCode() {
        if (piece == null) {
            return ChessConstants.EMPTY_CELL;
        }
        return piece.toString();
    }
}
