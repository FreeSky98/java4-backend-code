package log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.InputMismatchException;
import java.util.Scanner;

public class LogTest {
    // 创建日志记录器
    private static final Logger LOG = LoggerFactory.getLogger(LogTest.class);

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        try {
            LOG.debug("请输入被除数：");
            int num1 = input.nextInt();
            LOG.debug("请输入除数：");
            int num2 = input.nextInt();
            LOG.debug("等于：" + num1/num2);
        }
        catch (ArithmeticException e) {
            LOG.error("错误！两数必须是整数，不能除以0！");
        }
        catch (InputMismatchException e) {
            LOG.error("错误！两数必须是整数，不能除以0！");
        }
        catch(Exception ex) {
            LOG.error("未知错误");
        }
    }
}