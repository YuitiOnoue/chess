package parsers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import org.junit.Before;
import org.junit.Test;

import exceptions.ChessException;
import exceptions.parsemove.EmptyMoveException;
import exceptions.parsemove.InvalidPieceException;
import exceptions.parsemove.ParseMoveException;
import factory.BoardFactory;
import models.BoardModel;
import models.ColorEnum;
import models.MoveModel;
import models.pieces.PawnModel;

public class AlgebricNotationParserTest {

    private AlgebricNotationParser parser;
    private BoardModel pawnTestBoard;

    @Before
    public void setup() throws ChessException {
        parser = new AlgebricNotationParser();
        pawnTestBoard = createPawnTestBoard();
    }

    @Test(expected = EmptyMoveException.class)
    public void testParseNullCommand() throws ChessException {
        parser.parse(null, pawnTestBoard, ColorEnum.WHITE, 0);
    }

    @Test(expected = EmptyMoveException.class)
    public void testParseEmptyCommand() throws ChessException {
        parser.parse("", pawnTestBoard, ColorEnum.BLACK, 0);
    }

    @Test(expected = EmptyMoveException.class)
    public void testParseBlankCommand() throws ChessException {
        parser.parse("  ", pawnTestBoard, ColorEnum.WHITE, 0);
    }

    @Test
    public void testGetPieceClassPawns() throws ParseMoveException {
        assertEquals(PawnModel.class, parser.getPieceClass("a"));
        assertEquals(PawnModel.class, parser.getPieceClass("b"));
        assertEquals(PawnModel.class, parser.getPieceClass("c"));
        assertEquals(PawnModel.class, parser.getPieceClass("d"));
        assertEquals(PawnModel.class, parser.getPieceClass("e"));
        assertEquals(PawnModel.class, parser.getPieceClass("f"));
        assertEquals(PawnModel.class, parser.getPieceClass("g"));
        assertEquals(PawnModel.class, parser.getPieceClass("h"));
    }

    @Test
    public void testParseInvalidCommands() throws ChessException {
        assertThrows(InvalidPieceException.class, () -> parser.parse("A1", pawnTestBoard, ColorEnum.WHITE, 0));
        assertThrows(InvalidPieceException.class, () -> parser.parse("C7", pawnTestBoard, ColorEnum.BLACK, 0));
        assertThrows(InvalidPieceException.class, () -> parser.parse("x1", pawnTestBoard, ColorEnum.WHITE, 0));
        assertThrows(ChessException.class, () -> parser.parse("aa7", pawnTestBoard, ColorEnum.BLACK, 0));
    }


    @Test
    public void testParsePawmMovements() throws ChessException {
        MoveModel move = null;

        move = parser.parse("a5", pawnTestBoard, ColorEnum.BLACK, 1);
        assertEquals(move.getPiece().getClass(), PawnModel.class);
        assertEquals(move.getSourceSquare(), pawnTestBoard.getSquare("a7"));
        assertEquals(move.getTargetSquare(), pawnTestBoard.getSquare("a5"));

        move = parser.parse("b6", pawnTestBoard, ColorEnum.BLACK, 2);
        assertEquals(move.getPiece().getClass(), PawnModel.class);
        assertEquals(move.getSourceSquare(), pawnTestBoard.getSquare("b7"));
        assertEquals(move.getTargetSquare(), pawnTestBoard.getSquare("b6"));

        move = parser.parse("c5", pawnTestBoard, ColorEnum.BLACK, 3);
        assertEquals(move.getPiece().getClass(), PawnModel.class);
        assertEquals(move.getSourceSquare(), pawnTestBoard.getSquare("c6"));
        assertEquals(move.getTargetSquare(), pawnTestBoard.getSquare("c5"));

        move = parser.parse("a4", pawnTestBoard, ColorEnum.WHITE, 1);
        assertEquals(move.getPiece().getClass(), PawnModel.class);
        assertEquals(move.getSourceSquare(), pawnTestBoard.getSquare("a2"));
        assertEquals(move.getTargetSquare(), pawnTestBoard.getSquare("a4"));

        move = parser.parse("b3", pawnTestBoard, ColorEnum.WHITE, 2);
        assertEquals(move.getPiece().getClass(), PawnModel.class);
        assertEquals(move.getSourceSquare(), pawnTestBoard.getSquare("b2"));
        assertEquals(move.getTargetSquare(), pawnTestBoard.getSquare("b3"));

        move = parser.parse("c4", pawnTestBoard, ColorEnum.WHITE, 3);
        assertEquals(move.getPiece().getClass(), PawnModel.class);
        assertEquals(move.getSourceSquare(), pawnTestBoard.getSquare("c3"));
        assertEquals(move.getTargetSquare(), pawnTestBoard.getSquare("c4"));
    }

    @Test
    public void testParsePawmInvalidMovement() throws ChessException {
        // TODO create a new exception
        assertThrows(ChessException.class, () -> parser.parse("a0", pawnTestBoard, ColorEnum.BLACK, 1));
        assertThrows(ChessException.class, () -> parser.parse("a9", pawnTestBoard, ColorEnum.WHITE, 2));
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


    private BoardModel createPawnTestBoard() throws ChessException {

        BoardModel board = BoardFactory.createEmptyBoard();

        new PawnModel(ColorEnum.BLACK, board.getSquare("a7"));
        new PawnModel(ColorEnum.BLACK, board.getSquare("b7"));
        new PawnModel(ColorEnum.BLACK, board.getSquare("c6"));
        new PawnModel(ColorEnum.BLACK, board.getSquare("d5"));
        new PawnModel(ColorEnum.BLACK, board.getSquare("e5"));
        new PawnModel(ColorEnum.BLACK, board.getSquare("f5"));
        new PawnModel(ColorEnum.BLACK, board.getSquare("g3"));
        new PawnModel(ColorEnum.BLACK, board.getSquare("h7"));

        new PawnModel(ColorEnum.WHITE, board.getSquare("a2"));
        new PawnModel(ColorEnum.WHITE, board.getSquare("b2"));
        new PawnModel(ColorEnum.WHITE, board.getSquare("c3"));
        new PawnModel(ColorEnum.WHITE, board.getSquare("d4"));
        new PawnModel(ColorEnum.WHITE, board.getSquare("e4"));
        new PawnModel(ColorEnum.WHITE, board.getSquare("f4"));
        new PawnModel(ColorEnum.WHITE, board.getSquare("g2"));
        new PawnModel(ColorEnum.WHITE, board.getSquare("h6"));


        return board;
    }
}
