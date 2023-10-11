package exceptions.parsemove;

public class InvalidMoveException extends ParseMoveException {

    public InvalidMoveException() {
    }
 
    public InvalidMoveException(String message) {
       super(message);
    }
 
    public InvalidMoveException(String message, Throwable cause) {
       super(message, cause);
    }
 
    public InvalidMoveException(Throwable cause) {
       super(cause);
    }
 
    protected InvalidMoveException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
       super(message, cause, enableSuppression, writableStackTrace);
    }

} 