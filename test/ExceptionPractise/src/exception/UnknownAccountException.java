package exception;

/**
 * 未知账号异常类（业务异常类）
 */
public class UnknownAccountException extends Exception{
    public UnknownAccountException() {

    }

    public UnknownAccountException(String message) {
        super(message);
    }

    public UnknownAccountException(String message,Throwable cause) {
        super(message, cause);
    }
}
