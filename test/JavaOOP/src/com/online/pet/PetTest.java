package com.online.pet;

import java.util.Scanner;

public class PetTest {
    public static void main(String[] args) {
        Penguin penguin = new Penguin();
        Dog dog = new Dog();
        Scanner input = new Scanner(System.in);
        System.out.println("欢迎您来到宠物店！\n"+"请选择要领养的宠物名字：");
        String name = input.next();
        penguin.setName(name);
        dog.setName(name);

        System.out.print("请选择要领养的宠物类型：");
        int chooseType = input.nextInt();
        switch (chooseType) {
            case 1 -> {
                dog.setType(chooseType);
                System.out.print("请输入宠物的性别：");
                int chooseSex = input.nextInt();
                dog.setSex(chooseSex);
                System.out.print("请输入宠物的健康值（1~100之间）：");
                int health = input.nextInt();
                dog.setHealth(health);
                dog.showPetInfo();
            }
            case 2 -> {
                penguin.setType(chooseType);
                System.out.print("请输入宠物的性别：");
                int chooseSex = input.nextInt();
                penguin.setSex(chooseSex);
                System.out.print("请输入宠物的健康值（1~100之间）：");
                int health = input.nextInt();
                penguin.setHealth(health);
                penguin.showPetInfo();
            }
        }
    }
}
