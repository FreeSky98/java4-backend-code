package org.example;

import java.math.BigDecimal;

public class OverdraftException extends Exception{
    private BigDecimal deficit = new BigDecimal("1000.00");

    public OverdraftException() {

    }

    public OverdraftException(String message,BigDecimal deficit) {
        super(message);
        this.deficit = deficit;//对扩展的属性单独进行赋值
    }

    public OverdraftException(String message,Throwable cause,BigDecimal deficit) {
        super(message,cause);
        this.deficit = deficit;
    }

    public BigDecimal getDeficit() {
        return deficit;
    }

}
