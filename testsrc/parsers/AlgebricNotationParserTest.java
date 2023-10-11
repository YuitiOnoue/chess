package parsers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import org.junit.Before;
import org.junit.Test;

import exceptions.ChessException;
import exceptions.parsemove.EmptyMoveException;
import exceptions.parsemove.InvalidPieceException;
import factory.BoardFactory;
import models.BoardModel;
import models.ColorEnum;
import models.MoveModel;
import models.pieces.PawnModel;

public class AlgebricNotationParserTest {

    private AlgebricNotationParser parser;
    private BoardModel board;

    @Before
    public void setup() throws ChessException {
        parser = new AlgebricNotationParser();
        board = BoardFactory.createTestBoard();
    }

    @Test(expected = EmptyMoveException.class)
    public void parseNullCommand() throws ChessException {
        parser.parse(null, board, ColorEnum.WHITE, 0);
    }

    @Test(expected = EmptyMoveException.class)
    public void parseEmptyCommand() throws ChessException {
        parser.parse("", board, ColorEnum.BLACK, 0);
    }

    @Test(expected = EmptyMoveException.class)
    public void parseBlankCommand() throws ChessException {
        parser.parse("  ", board, ColorEnum.WHITE, 0);
    }

    @Test
    public void parseInvalidCommands() throws ChessException {
        assertThrows(InvalidPieceException.class, () -> parser.parse("A1", board, ColorEnum.WHITE, 0));
        assertThrows(InvalidPieceException.class, () -> parser.parse("C7", board, ColorEnum.BLACK, 0));
        assertThrows(InvalidPieceException.class, () -> parser.parse("x1", board, ColorEnum.WHITE, 0));
        assertThrows(ChessException.class, () -> parser.parse("aa7", board, ColorEnum.BLACK, 0));
    }

    @Test
    public void parsePawmMovements() throws ChessException {
        MoveModel move = parser.parse("a1", board, ColorEnum.BLACK, 1);
        assertEquals(move.getPiece().getClass(), PawnModel.class);

        move = parser.parse("b2", board, ColorEnum.WHITE, 2);
        assertEquals(move.getPiece().getClass(), PawnModel.class);

        move = parser.parse("c3", board, ColorEnum.BLACK, 3);
        assertEquals(move.getPiece().getClass(), PawnModel.class);

        move = parser.parse("d4", board, ColorEnum.WHITE, 4);
        assertEquals(move.getPiece().getClass(), PawnModel.class);

        move = parser.parse("e5", board, ColorEnum.BLACK, 5);
        assertEquals(move.getPiece().getClass(), PawnModel.class);

        move = parser.parse("f6", board, ColorEnum.WHITE, 6);
        assertEquals(move.getPiece().getClass(), PawnModel.class);

        move = parser.parse("g7", board, ColorEnum.BLACK, 7);
        assertEquals(move.getPiece().getClass(), PawnModel.class);

        move = parser.parse("h8", board, ColorEnum.WHITE, 8);
        assertEquals(move.getPiece().getClass(), PawnModel.class);
    }

    @Test
    public void parsePawmInvalidMovement() throws ChessException {
        // TODO create a new exception
        assertThrows(ChessException.class, () -> parser.parse("a0", board, ColorEnum.BLACK, 1));
        assertThrows(ChessException.class, () -> parser.parse("a9", board, ColorEnum.WHITE, 2));
    }

    // @Test
    // public void parsePawmCaptures() throws ChessException {
    //     MoveModel move = parser.parse("axb1", null, null, 0);
    //     assertEquals(move.getPiece().getClass(), PawnModel.class);

    //     move = parser.parse("bxc2", null, null, 0);
    //     assertEquals(move.getPiece().getClass(), PawnModel.class);

    //     move = parser.parse("cxd3", null, null, 0);
    //     assertEquals(move.getPiece().getClass(), PawnModel.class);

    //     move = parser.parse("dxe4", null, null, 0);
    //     assertEquals(move.getPiece().getClass(), PawnModel.class);

    //     move = parser.parse("exf5", null, null, 0);
    //     assertEquals(move.getPiece().getClass(), PawnModel.class);

    //     move = parser.parse("fxg6", null, null, 0);
    //     assertEquals(move.getPiece().getClass(), PawnModel.class);

    //     move = parser.parse("gxh7", null, null, 0);
    //     assertEquals(move.getPiece().getClass(), PawnModel.class);

    //     move = parser.parse("hxg8", null, null, 0);
    //     assertEquals(move.getPiece().getClass(), PawnModel.class);
    // }

}
