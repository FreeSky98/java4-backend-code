package lesson01;

import java.util.Scanner;

public class Visitor {
    String name;
    int age;
    double price;

    public void showPrice() {
        Scanner input = new Scanner(System.in);
        do {
            System.out.print("请输入姓名：");
            this.name = input.next();
            if("n".equalsIgnoreCase(this.name)) {
                System.out.println("退出程序");
                break;
            }
            System.out.print("请输入年龄：");
            this.age = input.nextInt();
            if (this.age < 18 || this.age > 60) {
                this.price = 0;
                System.out.println(name + "的年龄为" + age + ",门票免费");
            } else {
                this.price = 20;
                System.out.println(name + "的年龄为" + age + ",门票价格为:" + price + "元");
            }
        } while (true);
    }
}

class VisitorTest {
    public static void main(String[] args) {
        Visitor visitor = new Visitor();
        visitor.showPrice();
    }
}

