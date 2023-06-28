package org.example;

import java.math.BigDecimal;

/**
 * 银行账户类
 * @author Free_sky
 */
public class Account {
    private BigDecimal balance = new BigDecimal("500.78");//账户余额

    /**
     * 查询余额
     * @return 余额
     */
    public BigDecimal getBalance() {
        return balance;
    }

    public Account(BigDecimal balance) {
        this.balance = balance;
    }

    /**
     * 存款
     * @param amount
     */
    public void deposit(BigDecimal amount) {
        if (amount == null || amount.compareTo(BigDecimal.ZERO) == 0) {
            throw new IllegalArgumentException("交易失败，非法的交易金额！");
        }
        this.balance = balance.add(amount);
    }

    public void withdraw(BigDecimal amount) throws Exception {
        if (amount == null || amount.compareTo(BigDecimal.ZERO) == 0) {
            throw new IllegalArgumentException("交易失败，非法的交易金额！");
        }
        if (amount.compareTo(this.balance) == 1) {
            throw new Exception("交易失败，账户余额不足！");
        }
        this.balance = this.balance.subtract(amount);
    }
}
