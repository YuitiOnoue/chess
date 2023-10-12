package models;

import models.pieces.PieceModel;

public class MoveModel {

    private int round;
    private ColorEnum color;
    private PieceModel piece;
    private SquareModel sourceSquare;
    private SquareModel targetSquare;

    public MoveModel(int round, ColorEnum color, PieceModel piece, SquareModel sourceSquare, SquareModel targetSquare) {
        this.round = round;
        this.color = color;
        this.piece = piece;
        this.sourceSquare = sourceSquare;
        this.targetSquare = targetSquare;
    }

    public MoveModel(int round, PieceModel piece, SquareModel targetSquare) {
        this.round = round;
        this.color = piece.getColor();
        this.piece = piece;
        this.sourceSquare = piece.getSquare();
        this.targetSquare = targetSquare;
    }

    public int getRound() {
        return round;
    }

    public ColorEnum getColor() {
        return color;
    }

    public PieceModel getPiece() {
        return piece;
    }

    public SquareModel getSourceSquare() {
        return sourceSquare;
    }

    public SquareModel getTargetSquare() {
        return targetSquare;
    }

}
