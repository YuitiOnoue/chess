package models;

public class BoardModel {

    private CellModel[][] cells;

    public BoardModel(CellModel[][] cells) {
        this.cells = cells;
    }

    public CellModel[][] getCells() {
        return this.cells;
    }
    
}
