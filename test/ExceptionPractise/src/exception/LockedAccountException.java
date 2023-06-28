package exception;

/**
 * 未知账号异常类（业务异常类）
 */
public class LockedAccountException extends Exception{
    public LockedAccountException() {

    }

    public LockedAccountException(String message) {
        super(message);
    }

    public LockedAccountException(String message, Throwable cause) {
        super(message, cause);
    }
}
