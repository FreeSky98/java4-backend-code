package lesson01;

import java.util.Objects;
import java.util.Scanner;

public class PhoneBook {
    Scanner input = new Scanner(System.in);
    String name;
    char sex;
    int age;
    String phoneNumber;
    String qq;
    String address;
    PhoneBook[] phoneBooks = new PhoneBook[5];

    public PhoneBook(String name, char sex, int age, String phoneNumber, String qq, String address) {
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.qq = qq;
        this.address = address;
    }

    public PhoneBook() {

    }

    public void add() {
        for (int i = 0; i < phoneBooks.length; i++) {
            if (phoneBooks[i] == null) {
                System.out.println("------添加电话本------");
                System.out.println("请输入相关信息：");
                System.out.print("姓名：");
                String name = input.next();
                System.out.print("性别：");
                char sex = input.next().charAt(0);
                System.out.print("年龄：");
                int age = input.nextInt();
                System.out.print("电话：");
                String phoneNumber = input.next();
                System.out.print("QQ：");
                String qq = input.next();
                System.out.print("地址：");
                String address = input.next();
                PhoneBook phoneBook = new PhoneBook(name, sex, age, phoneNumber, qq, address);
                phoneBooks[i] = phoneBook;
                System.out.println("添加成功");
                System.out.println("姓名：" + name + "性别：" + sex + "年龄：" + age + "电话：" + phoneNumber + "QQ：" + qq + "地址：" + address);
                break;
            } else {
                System.out.println("电话簿内存已满！");
            }
        }
    }

    public void delete() {
        System.out.println("请输入需要删除的电话簿序号：");
        int delNum = input.nextInt();
        for (int i = 0; i < phoneBooks.length; i++) {
            if (phoneBooks[i] != null && delNum <= phoneBooks.length) {
                phoneBooks[delNum] = null;
                System.out.println("删除成功");
                break;
            } else {
                System.out.println("未找到需要删除的电话信息");
            }
        }
    }

    public void update() {
        System.out.println("请输入需要修改的电话簿序号：");
        int updateNum = input.nextInt();
        int count = 0;
        for (int i = 0; i < phoneBooks.length; i++) {
            if (phoneBooks[i] != null && updateNum <= phoneBooks.length) {
                phoneBooks[updateNum] = null;
                count++;
                add();
                break;
            }
        }
        if (count == 0) {
            System.out.println("未找到需要修改的电话信息");
        }
    }

    public void check() {
        int count = 0;
        for (int i = 0; i < phoneBooks.length; i++) {
            if (phoneBooks[i] != null) {
                count++;
                System.out.print("姓名：" + phoneBooks[i].name);
                System.out.print("性别：" + phoneBooks[i].sex);
                System.out.print("年龄：" + phoneBooks[i].age);
                System.out.print("电话：" + phoneBooks[i].phoneNumber);
                System.out.print("QQ：" + phoneBooks[i].qq);
                System.out.print("地址：" + phoneBooks[i].address);
            }
        }
        if (count == 0) {
            System.out.println("电话簿为空，无法查询！");
        }
    }

    public void checkName() {
        System.out.println("请输入需要查找的姓名：");
        String checkName = input.next();
        int count = 0;
        for (int i = 0; i < phoneBooks.length; i++) {
            if (phoneBooks[i] != null && Objects.equals(phoneBooks[i].name, checkName)) {
                count++;
                System.out.print("姓名：" + phoneBooks[i].name);
                System.out.print("性别：" + phoneBooks[i].sex);
                System.out.print("年龄：" + phoneBooks[i].age);
                System.out.print("电话：" + phoneBooks[i].phoneNumber);
                System.out.print("QQ：" + phoneBooks[i].qq);
                System.out.println("地址：" + phoneBooks[i].address);
            }
        }
        if (count == 0) {
            System.out.println("未找到需要查找的姓名，无法查询！");
        }
    }
}

class PhoneBookTest {
    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();
        loop1:
        while (true) {
            System.out.println("\n----------电话簿管理系统-----------");
            System.out.println("1.添加 2.删除 3.修改 4.查询所有 5.根据姓名查询 0.退出");
            System.out.println("----------电话簿管理系统-----------");
            System.out.println("请选择操作：");
            Scanner input = new Scanner(System.in);
            int choose = input.nextInt();
            switch (choose) {
                case 0 -> {
                    break loop1;
                }
                case 1 -> phoneBook.add();
                case 2 -> phoneBook.delete();
                case 3 -> phoneBook.update();
                case 4 -> phoneBook.check();
                case 5 -> phoneBook.checkName();
            }
        }
    }
}
