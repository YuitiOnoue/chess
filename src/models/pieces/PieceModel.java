package models.pieces;

import exceptions.ChessException;
import models.ColorEnum;
import models.SquareModel;

public abstract class PieceModel implements Piece {

    private ColorEnum color;
    private SquareModel square;

    public PieceModel(ColorEnum color) {
        this.color = color;
    }

    public PieceModel(ColorEnum color, SquareModel square) throws ChessException {
        this.color = color;
        this.setSquare(square);
    }

    public ColorEnum getColor() {
        return this.color;
    }

    public void setSquare(SquareModel square) throws ChessException {
        this.square = square;

        if (square == null) {
            return;
        } else if (square.getPiece() == null) {
            square.setPiece(this);
        } else if (square.getPiece() != this) {
            // TODO create a new Exception
            throw new ChessException("Invalid set to piece");
        } else if (square.getPiece() == this) {
            // TODO create a new Exception
            throw new ChessException("Piece already setted");
        }
    }

    @Override
    public void move(SquareModel targetSquare) throws ChessException {

        if (canMove(targetSquare)) {
            this.setSquare(targetSquare);
            return;
        }

        throw new ChessException("Invalid move");
    }

    public SquareModel getSquare() {
        return this.square;
    }

    public boolean isBlack() {
        return ColorEnum.BLACK.equals(this.getColor());
    }

    public boolean isWhite() {
        return ColorEnum.WHITE.equals(this.getColor());
    }

}
