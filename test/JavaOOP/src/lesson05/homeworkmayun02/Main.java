package lesson05.homeworkmayun02;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("请输入武器库容量：");
        int weaponNumber = input.nextInt();
        Army army01 = new Army(weaponNumber);
        System.out.println("您最多拥有" + weaponNumber + "个武器！！！");

        for (int i = 0; i < weaponNumber; i++) {
            System.out.println("输入yes添加武器，输入其他则不录入");
            String choose = input.next();
            if (choose.equalsIgnoreCase("yes")) {
                System.out.println("1.坦克   2.战斗机   3.军舰\n请选择：");
                int chooseWeapon = input.nextInt();
                switch (chooseWeapon) {
                    case 1 -> army01.addWeapon(new Tank());
                    case 2 -> army01.addWeapon(new Airplane());
                    case 3 -> army01.addWeapon(new Ship());
                }
            }
            else break;
        }
        army01.attackAll();
        army01.moveAll();
    }
}
