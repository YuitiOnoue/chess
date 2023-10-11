package exceptions.parsemove;

public class InvalidPieceException extends ParseMoveException {

    public InvalidPieceException() {
    }
 
    public InvalidPieceException(String message) {
       super(message);
    }
 
    public InvalidPieceException(String message, Throwable cause) {
       super(message, cause);
    }
 
    public InvalidPieceException(Throwable cause) {
       super(cause);
    }
 
    protected InvalidPieceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
       super(message, cause, enableSuppression, writableStackTrace);
    }

} 