package cz.muni.fi.pb162.project.exception;

/**
 * @author Pavel Shishkin
 */
public class EmptyDrawableException extends Exception {
    /**
     * @param message is error msg
     * @param m is a throw
     */
    public EmptyDrawableException(String message, Throwable m){
        super(message, m);
    }
    /**
     * @param message is error msg
     */
    public EmptyDrawableException(String message){
        super(message);
    }

}
