package com.kgc.rent;

import java.util.Scanner;

public class VehicleRentApplication {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Vehicle v;//保存一个汽车对象

        System.out.println("***********欢迎光临腾飞汽车租赁公司***********");
        System.out.println("1、轿车 \t2、客车\t3、卡车");
        System.out.print("请选择你要租赁的汽车类型：");
        int motoType = input.nextInt();
        String brand = "";
        String type = "";
        int seat = 0;
        int load = 0;

        if (motoType == 1) {
            System.out.print("请选择你要租赁的汽车品牌：1、别克 2、宝马");
            int choose2 = input.nextInt();
            if (choose2 == 1) {
                brand = "别克";
                System.out.print("请选择你要租赁的汽车类型：1、林荫大道 2、GL8");
                type = (input.nextInt() == 1) ? "林荫大道" : "GL8";
            } else if (choose2 == 2) {
                brand = "宝马";
                System.out.print("请选择你要租赁的汽车类型：1、X6  2、550i");
                type = (input.nextInt() == 1) ? "X6" : "550i";
            }
        } else if (motoType == 2) {
            type = "";
            System.out.print("请选择你要租赁的汽车品牌：1、金龙 2、金杯");
            brand = (input.nextInt() == 1) ? "金龙" : "金杯";
            System.out.print("请选择你要租赁的汽车座位数：1、16座 2、34座");
            seat = (input.nextInt() == 1) ? 16 : 34;
        } else if (motoType == 3) {
            type = "";
            System.out.print("请选择你要租赁的汽车品牌：1、一汽解放 2、重庆红岩");
            brand = (input.nextInt() == 1) ? "一汽解放" : "重庆红岩";
            System.out.print("请选择你要租赁的汽车载重量：1、40吨 2、60吨");
            load = (input.nextInt() == 1) ? 40 : 60;
        }
        v = VehicleService.rentCar(brand, type, load, seat);//获得一个具体的汽车对象
        System.out.print("请输入您要租赁的天数：");
        int days = input.nextInt();
        double totalPrice = v.getTotalPrice(days);//租赁费用
        System.out.println("分配给您的汽车牌号是：" + v.getLicenseNo());
        System.out.println("您需要支付的租赁费用是：" + totalPrice + "元。");
    }
}
