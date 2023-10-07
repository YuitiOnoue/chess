package models;

public interface PieceInterface {

    boolean isEmpty();

    boolean canMove(PieceModel piece, CellModel destiny, BoardModel board);

    String toString();

}
