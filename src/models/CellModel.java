package models;

import constants.ChessConstants;

public class CellModel {

    int row;
    ColumnEnum column;
    PieceInterface piece;

    public CellModel(int row, ColumnEnum column, PieceInterface piece) {
        this.row = row;
        this.column = column;
        this.piece = piece;
    }

    public CellModel(int row, ColumnEnum column) {
        this(row, column, null);
    }

    public int getRow() {
        return row;
    }

    public ColumnEnum getColumn() {
        return column;
    }

    public PieceInterface getPiece() {
        return piece;
    }

    public void setPiece(PieceInterface piece) {
        this.piece = piece;
    }

    public String toString() {
        if (piece == null || piece.isEmpty()) {
            return ChessConstants.EMPTY_CELL;
        }
        return piece.toString();
    }
}
