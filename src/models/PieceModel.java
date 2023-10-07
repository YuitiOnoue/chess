package models;

public class PieceModel implements PieceInterface {

    private ColorEnum color;
    private CellModel position;

    @Override
    public boolean canMove(PieceModel piece, CellModel destiny, BoardModel board) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'canMove'");
    }

    @Override
    public boolean isEmpty() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isEmpty'");
    }
    
}
