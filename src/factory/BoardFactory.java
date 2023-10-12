package factory;

import models.BoardModel;
import models.ColorEnum;
import models.SquareModel;
import models.pieces.PawnModel;
import models.FileEnum;

import static constants.ChessConstants.BOARD_SIZE;

import exceptions.ChessException;

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

    public static BoardModel createTestBoard() throws ChessException {

        BoardModel board = createEmptyBoard();

        new PawnModel(ColorEnum.BLACK, board.getSquare("a7"));
        new PawnModel(ColorEnum.BLACK, board.getSquare("b7"));
        new PawnModel(ColorEnum.BLACK, board.getSquare("c7"));
        new PawnModel(ColorEnum.BLACK, board.getSquare("d7"));
        new PawnModel(ColorEnum.BLACK, board.getSquare("e7"));
        new PawnModel(ColorEnum.BLACK, board.getSquare("f7"));
        new PawnModel(ColorEnum.BLACK, board.getSquare("g7"));
        new PawnModel(ColorEnum.BLACK, board.getSquare("h7"));

        new PawnModel(ColorEnum.WHITE, board.getSquare("a2"));
        new PawnModel(ColorEnum.WHITE, board.getSquare("b2"));
        new PawnModel(ColorEnum.WHITE, board.getSquare("c2"));
        new PawnModel(ColorEnum.WHITE, board.getSquare("d2"));
        new PawnModel(ColorEnum.WHITE, board.getSquare("e2"));
        new PawnModel(ColorEnum.WHITE, board.getSquare("f2"));
        new PawnModel(ColorEnum.WHITE, board.getSquare("g2"));
        new PawnModel(ColorEnum.WHITE, board.getSquare("h2"));
        return board;
    }

}
