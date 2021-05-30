package cz.muni.fi.pb162.project.exception;

/**
 * @author Pavel Shishkin
 */
public class MissingVerticesException extends RuntimeException{
    /**
     * @param message is error msg
     */
    public MissingVerticesException(String message){
        super(message);
    }
    /**
     * @param message is error msg
     * @param t is throw
     */
    public MissingVerticesException(String message, Throwable t){
        super(message, t);
    }

}
