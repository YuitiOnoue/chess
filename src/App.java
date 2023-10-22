import java.util.Scanner;

import drawers.BoardDrawer;
import exceptions.ChessException;
import exceptions.parsemove.ParseMoveException;
import factory.BoardFactory;
import models.BoardModel;
import models.ColorEnum;
import models.MoveModel;
import parsers.AlgebricNotationParser;

public class App {
    
    public static void main(String[] args) throws Exception {
        menu();
    }

    public static void menu() throws ChessException {

        try (Scanner in = new Scanner(System.in)) {
            String comando;

            BoardModel board = BoardFactory.createTestBoard();
            AlgebricNotationParser parser = new AlgebricNotationParser();
            ColorEnum turnColor = ColorEnum.WHITE;
            int playCounter = 1;
            int round = 1;

            do {
                drawBoard(board);
                System.out.println("Turn " + round + ": " + turnColor);
                comando = in.nextLine();

                if (comando.equals("clear")) {
                    clearScreen();
                } else if (comando.equals("board")) {
                    drawBoard(board);
                } else if (!comando.equals("exit")) {
                    try {

                        MoveModel move = parser.parse(comando, board, turnColor, round);
                        move.execute();
                        turnColor = ColorEnum.WHITE.equals(turnColor) ? ColorEnum.BLACK : ColorEnum.WHITE;
                        playCounter++;
                        round = (playCounter % 2 == 1) ? round + 1 : round;
                    } catch (ParseMoveException e) {
                        System.out.println(e);
                        comando = in.nextLine();
                    }
                }

            } while (!comando.equals("exit"));

            in.close();
        }

    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void drawBoard(BoardModel board) throws ChessException {
        clearScreen();
        System.out.println(BoardDrawer.drawBoard(board));
    }
}
