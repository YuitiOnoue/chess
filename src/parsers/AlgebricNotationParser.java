package parsers;

import constants.ChessConstants;
import exceptions.parsemove.EmptyMoveException;
import exceptions.parsemove.InvalidMoveException;
import exceptions.parsemove.InvalidPieceException;
import exceptions.parsemove.ParseMoveException;
import models.BoardModel;
import models.ColorEnum;
import models.MoveModel;
import models.SquareModel;
import models.pieces.PawnModel;
import models.pieces.PieceModel;
import services.BoardService;
import services.impl.DefaultBoardService;

public class AlgebricNotationParser implements Parser {

    private BoardService boardService = new DefaultBoardService();

    @Override
    public MoveModel parse(String moveString, BoardModel board, ColorEnum color, int round) throws ParseMoveException {

        try {

            if (isEmptyMove(moveString)) {
                throw new EmptyMoveException("Command must not be empty");
            }

            boardService.validateBoard(board);

            // TODO create special moves (castle)
            // if (specialMove(command)) {

            // return new MoveModel(0, null, null);;
            // }

            if (moveString.length() < 2) {
                throw new InvalidMoveException("move string to short");
            }

            Class<? extends PieceModel> pieceClass = getPieceClass(moveString.substring(0, 1));
            SquareModel targetSquare = board
                    .getSquare(moveString.substring(moveString.length() - 2, moveString.length()));

            PieceModel piece = boardService.getPieceAbleToMoveToSquare(board, color, pieceClass, targetSquare);

            return new MoveModel(round, piece, targetSquare);
        } catch (ParseMoveException e) {
            throw e;
        } catch (Exception e) {
            throw new ParseMoveException(e);
        }
    }

    @Override
    public boolean validateMove(MoveModel move) throws ParseMoveException {
        if (move == null || move.getPiece() == null) {
            return false;
        }

        return move.getPiece().canMove(move.getTargetSquare());
    }

    public Class<? extends PieceModel> getPieceClass(String pieceLetter) throws ParseMoveException {

        if (pieceLetter.matches(ChessConstants.FILES_REGEX)) {
            return PawnModel.class;
        }

        throw new InvalidPieceException("Not a valid piece");
    }

    private boolean isEmptyMove(String moveString) {
        return moveString == null || moveString.isBlank();
    }
}
