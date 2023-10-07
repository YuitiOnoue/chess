package factory;

import models.BoardModel;
import models.CellModel;
import models.ColumnEnum;

import static constants.ChessConstants.BOARD_SIZE;

public class BoardFactory {

    public static BoardModel createEmptyBoard() {

        CellModel cells[][] = new CellModel[BOARD_SIZE][BOARD_SIZE];

        for (int r = 0; r < BOARD_SIZE; r++) {
            for (int c = 0; c < BOARD_SIZE; c++) {
                cells[r][c] = new CellModel(r + 1, ColumnEnum.values()[c]);
            }
        }

        return new BoardModel(cells);
    }

}
