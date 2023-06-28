package exception;

/**
 * 未知账号异常类（业务异常类）
 */
public class IncorrectPasswordException extends Exception{
    public IncorrectPasswordException() {

    }

    public IncorrectPasswordException(String message) {
        super(message);
    }

    public IncorrectPasswordException(String message, Throwable cause) {
        super(message, cause);
    }
}
