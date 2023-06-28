package lesson05.homework01;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        UseCompute user = new UseCompute();
        Scanner input = new Scanner(System.in);
        System.out.println("打开计算器 ...\n请输入第一个数：");
        int one = input.nextInt();
        System.out.println("请输入第二个数：");
        int two = input.nextInt();
        System.out.println("请输入运算符：");
        String op = input.next();
        switch (op) {
            case "+" -> user.useCom(new Add(),one,two);
            case "-" -> user.useCom(new Minus(),one,two);
            case "*" -> user.useCom(new Multiply(),one,two);
            case "/" -> user.useCom(new Divide(),one,two);
        }
    }
}
