package models.pieces;

import exceptions.ChessException;
import models.ColorEnum;
import models.SquareModel;

public class PawnModel extends PieceModel {

    public PawnModel(ColorEnum color) {
        super(color);
    }

    public PawnModel(ColorEnum color, SquareModel square) throws ChessException {
        super(color, square);
    }

    @Override
    public boolean canMove(SquareModel targetSquare) {
        if (targetSquare == null) {
            return false;
        }

        int orientation = isBlack() ? -1 : 1;
        int sourceRank = this.getSquare().getRank();
        int targetRank = targetSquare.getRank();

        boolean isSameFile = this.getSquare().getFile().equals(targetSquare.getFile());

        // pawn move
        if (isSameFile) {

            // black two squares move
            if (isBlack() && sourceRank == 7 && targetRank == 5) {
                return true;
            }

            // white two squares move
            if (isWhite() && sourceRank == 2 && targetRank == 4) {
                return true;
            }

            // one square move
            if ((targetRank - sourceRank) == orientation) {
                return true;
            }
        }

        // capture
        return canCapture(targetSquare);
    }

    @Override
    public boolean canCapture(SquareModel targetSquare) {

        int orientation = isBlack() ? -1 : 1;
        int sourceRank = this.getSquare().getRank();
        int sourceFileIndex = this.getSquare().getFile().ordinal();

        int targetRank = targetSquare.getRank();
        int targetFileIndex = targetSquare.getFile().ordinal();

        boolean isAdjancentFile = Math.abs(sourceFileIndex - targetFileIndex) == 1;
        boolean isInMoveRange = (sourceRank - targetRank) == orientation;
        boolean hasEnemyPiece = targetSquare.getPiece() != null
                && !(targetSquare.getPiece().getColor().equals(this.getColor()));

        return isAdjancentFile && isInMoveRange && hasEnemyPiece;
    }

    @Override
    public String toString() {
        return this.getColor().toString() + this.getSquare().getFile().toString();
    }

}
