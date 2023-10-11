import java.util.Scanner;

import drawers.BoardDrawer;
import exceptions.ChessException;
import factory.BoardFactory;
import models.BoardModel;

public class App {
    public static void main(String[] args) throws Exception {
        menu();
    }

    public static void menu() throws ChessException {

        try (Scanner in = new Scanner(System.in)) {
            String comando;

            do {
                comando = in.nextLine();

                if (comando.equals("limpa")) {
                    limpa();
                } else if (comando.equals("board")) {
                    board();
                } else {
                    System.out.println("Teste");
                    System.out.println(comando);
                }

            } while (!comando.equals("exit"));

            in.close();
        }

    }

    public static void limpa() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void board() throws ChessException {
        BoardModel board = BoardFactory.createTestBoard();

        System.out.println(BoardDrawer.drawBoard(board));
    }
}
