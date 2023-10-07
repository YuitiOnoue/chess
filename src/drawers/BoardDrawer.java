package drawers;

import static constants.ChessConstants.*;

import models.BoardModel;
import models.CellModel;

public class BoardDrawer {

    public static String drawBoard(BoardModel board) {

        if (board == null) {
            throw new IllegalArgumentException("board must no be null");
        }

        CellModel cells[][] = board.getCells();

        if (cells == null) {
            throw new IllegalArgumentException("board not instancied");
        }

        StringBuilder sb = new StringBuilder();

        for (int r = 0; r < BOARD_SIZE; r++) {

            sb.append(drawHorizontalLine());
            sb.append(System.lineSeparator());

            for (int c = 0; c < BOARD_SIZE; c++) {

                sb.append("|");
                if (cells[r][c] != null) {
                    sb.append(cells[r][c].toString());
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
