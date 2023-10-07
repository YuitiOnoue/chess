package drawers;

import static constants.ChessConstants.*;

import models.BoardModel;
import models.SquareModel;

public class BoardDrawer {

    public static String drawBoard(BoardModel board) {

        if (board == null) {
            throw new IllegalArgumentException("board must no be null");
        }

        SquareModel squares[][] = board.getSquares();

        if (squares == null) {
            throw new IllegalArgumentException("board squares not instancied");
        }

        StringBuilder sb = new StringBuilder();

        for (int r = 0; r < BOARD_SIZE; r++) {

            sb.append(drawHorizontalLine());
            sb.append(System.lineSeparator());

            for (int c = 0; c < BOARD_SIZE; c++) {

                sb.append("|");
                if (squares[r][c] != null) {
                    sb.append(squares[r][c].toString());
                }
            }
            sb.append("|");
            sb.append(System.lineSeparator());
        }

        sb.append(drawHorizontalLine());
        sb.append(System.lineSeparator());

        return sb.toString();
    }

    private static String drawHorizontalLine() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < BOARD_SIZE * (CELL_SIZE + 1) + 1; i++) {
            sb.append("-");
        }
        return sb.toString();
    }

}
