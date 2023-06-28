package lesson06.demo;

public class NotEnoughMoneyException extends Exception{

    public NotEnoughMoneyException() {
    }

    public NotEnoughMoneyException(String message) {
        super(message);
    }

    public NotEnoughMoneyException(Throwable cause) {
        super(cause);
    }
}

