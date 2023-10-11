package parsers;

import exceptions.parsemove.ParseMoveException;
import models.BoardModel;
import models.ColorEnum;
import models.MoveModel;

public interface Parser {

    MoveModel parse(String moveString, BoardModel board, ColorEnum color, int round) throws ParseMoveException;

    boolean validateMove(MoveModel move) throws ParseMoveException;

};