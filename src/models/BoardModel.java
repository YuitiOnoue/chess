package models;

public class BoardModel {

    private static final int SIZE = 8;
    
    private CellModel[][] board;

    public BoardModel(CellModel[][] board) {
        this.board = board;
    }

    public static BoardModel createEmptyBoard() {

        CellModel cells[][] = new CellModel[SIZE][SIZE];

        for (int r = 0; r < SIZE; r++) {
            for(int c = 0; c < SIZE; c++) {
                cells[r][c] = new CellModel(r+1, ColumnEnum.values()[c]);
            }
        }

        return new BoardModel(cells);
    }

    public String toString() {
        
    }
}
