package org.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;

/**
 * 应用程序测试类
 */
public class AppTest {
    // 创建一个新的日志记录器对象
    private static final Logger LOGGER = LoggerFactory.getLogger(AppTest.class);

    public static void main(String[] args) {
        // 创建银行账户对象
        Account account = new Account(new BigDecimal("1000"));
        // 模拟查询余额
        LOGGER.debug("当前您银行账户的余额是：" + account.getBalance() + "元。");
        // 模拟存款
        account.deposit(new BigDecimal("2000"));
        LOGGER.debug("存款成功，当前账户的余额是：" + account.getBalance() + "元。");
        try {
            //模拟取款
            account.withdraw(new BigDecimal("1200"));
            LOGGER.debug("取款成功，当前账户的余额是：" + account.getBalance() + "元。");
        }catch (Exception ex){
            LOGGER.error("操作错误原因："+ex.getMessage());
        }
    }
}