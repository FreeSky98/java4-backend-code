package lesson01;

import java.util.Scanner;

public class GuessMachineTest {
    public static void main(String[] args) {
        GuessMachine guessMachine = new GuessMachine();
        guessMachine.initial();
        guessMachine.guess();
    }
}

class GuessMachine {
    String brand;
    int price;
    public void initial() {
        int randomNum = (int) ((Math.random() * 10) / 2) + 1;
        switch (randomNum) {
            case 1 -> {
                this.brand = "小米电视";
                this.price = 1388;
            }
            case 2 -> {
                this.brand = "三星电视";
                this.price = 1488;
            }
            case 3 -> {
                this.brand = "华硕电视";
                this.price = 1188;
            }
            case 4 -> {
                this.brand = "苹果电视";
                this.price = 2088;
            }
            case 5 -> {
                this.brand = "蜂鸟电视";
                this.price = 888;
            }
        }
        System.out.println("接下来出现的商品是：" + this.brand);
    }

    public void guess() {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入您猜测的价格：");
        int guessNumber = input.nextInt();

        for (int i = 4; i > 0; i--) {
            if (guessNumber == price) {
                System.out.println("猜对了！恭喜您获得" + brand);
                break;
            }
            if (guessNumber > price) {
                System.out.println("再小些！  您还有"+ i + "次机会");
                System.out.println("您请输入您猜测的价格：");
                guessNumber = input.nextInt();
            }
            if (guessNumber < price) {
                System.out.println("再大些！！  您还有"+ i + "次机会");
                System.out.println("请输入您猜测的价格：");
                guessNumber = input.nextInt();
            }
            System.out.println("很遗憾您没有猜对，再接再厉！");
        }
    }
}