package com.wqq.zoo;

import java.util.Scanner;

public class Test {
    static Scanner input = new Scanner(System.in);
    static Animal[] animals = new Animal[] {
            new Cat("加菲猫",4),
            new Duck("唐老鸭",2),
            new Dolphin("海豚奇奇")};

    public static void main(String[] args) {
            load();
            System.out.println("是否要继续修改数据：按0进行修改操作，其他任意数字键退出");
            int choose = input.nextInt();
            if (choose == 0) {
            try {
                modify();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void load() {
        System.out.println("动物名字\t\t\t腿的条数\t\t\t动物叫");
        for (Animal animal : animals) {
            System.out.print(animal);
            if (animal instanceof Cat) {
                System.out.print(((Cat) animal).getLegNum()+"\t\t\t\t");
            } else if (animal instanceof Duck) {
                System.out.print(((Duck) animal).getLegNum()+"\t\t\t\t");
            } else {
                System.out.print(0 + "\t\t\t\t");
            }
            animal.shout();
        }
    }

    public static void modify() throws Exception{
        System.out.println("请输入猫的名称：");
        String catName = input.next();
        System.out.println("请输入猫腿的条数：");
        int catLegs = input.nextInt();
        if (catLegs > 4) {
            throw new Exception("猫最多只能有4条腿");
        }
        Cat cat = new Cat(catName,catLegs);
        System.out.println("请输入鸭子的名称：");
        String duckName = input.next();
        System.out.println("请输入鸭腿的条数：");
        int duckLegs = input.nextInt();
        if (duckLegs > 2) {
            throw new Exception("鸭子最多只能有2条腿");
        }
        Duck duck = new Duck(duckName,duckLegs);
        System.out.println("请输入海豚的名称：");
        String dolphinName = input.next();
        Dolphin dolphin = new Dolphin(dolphinName);
        animals[0] = cat;
        animals[1] = duck;
        animals[2] = dolphin;
        load();
    }
}
