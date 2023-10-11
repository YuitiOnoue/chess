package exceptions.parsemove;

public class EmptyMoveException extends ParseMoveException {

    public EmptyMoveException() {
    }
 
    public EmptyMoveException(String message) {
       super(message);
    }
 
    public EmptyMoveException(String message, Throwable cause) {
       super(message, cause);
    }
 
    public EmptyMoveException(Throwable cause) {
       super(cause);
    }
 
    protected EmptyMoveException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
       super(message, cause, enableSuppression, writableStackTrace);
    }

} 