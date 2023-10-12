package exceptions.parsemove;

import exceptions.ChessException;

public class ParseMoveException extends ChessException {

    public ParseMoveException() {
    }
 
    public ParseMoveException(String message) {
       super(message);
    }
 
    public ParseMoveException(String message, Throwable cause) {
       super(message, cause);
    }
 
    public ParseMoveException(Throwable cause) {
       super(cause);
    }
 
    protected ParseMoveException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
       super(message, cause, enableSuppression, writableStackTrace);
    }

} 