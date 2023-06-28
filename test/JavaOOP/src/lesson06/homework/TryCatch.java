package lesson06.homework;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TryCatch {
    public static int divide(int a,int b) throws RuntimeException{
        return a / b;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        try {
            System.out.print("请输入被除数：");
            int a = input.nextInt();
            System.out.print("请输入除数：");
            int b = input.nextInt();
            System.out.println("结果为："+divide(a,b));
        } catch (ArithmeticException e) {
            System.err.println("出现错误：除数不能为零。");
            e.printStackTrace();
        } catch (InputMismatchException e) {
            System.err.println("出现错误：被除数和除数必须是整数。");
            e.printStackTrace();
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            System.out.println("感谢使用本程序！");
            //return;
        }
    }
}
