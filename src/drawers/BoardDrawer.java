package drawers;

import static constants.ChessConstants.BOARD_SIZE;
import static constants.ChessConstants.CELL_SIZE;

import exceptions.ChessException;
import models.BoardModel;
import services.BoardService;
import services.impl.DefaultBoardService;

public class BoardDrawer {

    public static String drawBoard(BoardModel board) throws ChessException {
        
        BoardService boardService = new DefaultBoardService();

        boardService.validateBoard(board);

        StringBuilder sb = new StringBuilder();

        for (int rank = BOARD_SIZE -1; rank >= 0 ; rank--) {

            sb.append(drawHorizontalLine());
            sb.append(System.lineSeparator());

            for (int file = 0; file < BOARD_SIZE; file++) {

                sb.append("|");
                if (board.getSquare(rank, file) != null) {
                    sb.append(board.getSquare(rank, file).getPieceCode());
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
