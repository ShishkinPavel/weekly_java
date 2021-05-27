package cz.muni.fi.pb162.project.exception;

/**
 * @author Pavel Shishkin
 */
public class TransparentColorException extends Exception{
    /**
     * @param message is error msg
     */
    public TransparentColorException(String message){
        super(message);
    }
    /**
     * @param message is error msg
     * @param t is throw
     */
    public TransparentColorException(String message, Throwable t){
        super(message, t);
    }
}
