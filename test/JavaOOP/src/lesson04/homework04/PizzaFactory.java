package lesson04.homework04;

import java.util.Scanner;

public class PizzaFactory {
    public void CreatePizza() {
        Scanner input = new Scanner(System.in);
        Pizza p1;
        Pizza p2;
        System.out.print("请选择想要制作的披萨(1.培根披萨 2.海鲜披萨):");
        int choose = input.nextInt();
        switch (choose) {
            case 1 -> {
                System.out.println("请输入培根克数：");
                int gram = input.nextInt();
                System.out.println("请输入披萨大小：");
                int size = input.nextInt();
                System.out.println("请输入披萨价格：");
                double price = input.nextDouble();
                p1 = new BaconPizza(price,size,gram);
                System.out.println(p1.showInfo());
            }
            case 2 -> {
                System.out.println("请输入配料信息：");
                String topping = input.next();
                System.out.println("请输入披萨大小：");
                int size = input.nextInt();
                System.out.println("请输入披萨价格：");
                double price = input.nextDouble();
                p2 = new SeafoodPizza(price,size,topping);
                System.out.println(p2.showInfo());
            }
        }
    }
}
