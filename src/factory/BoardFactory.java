package factory;

import models.BoardModel;
import models.ColorEnum;
import models.SquareModel;
import models.pieces.PawnModel;
import models.FileEnum;

import static constants.ChessConstants.BOARD_SIZE;

public class BoardFactory {

    public static BoardModel createEmptyBoard() {

        SquareModel squares[][] = new SquareModel[BOARD_SIZE][BOARD_SIZE];

        for (int r = 0; r < BOARD_SIZE; r++) {
            for (int c = 0; c < BOARD_SIZE; c++) {
                squares[r][c] = new SquareModel(r + 1, FileEnum.values()[c]);
            }
        }

        return new BoardModel(squares);
    }

    public static BoardModel createTestBoard() {

        BoardModel board = createEmptyBoard();
        SquareModel squares[][] = board.getSquares();

        new PawnModel(ColorEnum.BLACK, squares[0][0]);

        return board;
    }

}
