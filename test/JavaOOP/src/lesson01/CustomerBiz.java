package lesson01;

import java.text.CollationKey;
import java.text.Collator;
import java.util.Arrays;
import java.util.Locale;
import java.util.Objects;
import java.util.Scanner;
public class CustomerBiz {
    String[] names = new String[5];
    boolean addName(String name) {
        for (int i = 0; i < names.length; i++) {
            if (names[i] == null) {
                names[i] = name;
                return true;
            }
        }
        return false;
    }
    boolean updateName(String oldName,String newName) {
        for (int i = 0; i < names.length; i++) {
            if (names[i] != null && Objects.equals(names[i], oldName)) {
                names[i] = newName;
                return true;
            }
            else {
                System.out.println("未找到您需要更新的客户姓名！");
            }
        }
        return false;
    }
    void sortName(String[] names) {
        Arrays.sort(names,(str1, str2)->{
            Collator collator = Collator.getInstance(Locale.CHINESE);
            CollationKey key1 = collator.getCollationKey(str1);
            CollationKey key2 = collator.getCollationKey(str2);
            return key1.compareTo(key2);
        });
        System.out.println("客户姓名排序后"+Arrays.toString(names));
    }
    boolean deleteName(String name) {
        for (int i = 0; i < names.length; i++) {
            if (names[i] != null && Objects.equals(names[i], name)) {
                names[i] = names[i+1];
                names[i] = null;
                return true;
            } else {
                System.out.println("未找到您要删除的客户姓名！");
            }
        }
        return false;
    }
    String[] searchName(int start,int end,String name) {
        String[] search = new String[5];
        int count = 0;
        for (int i = start - 1; i < end; i++) {
            if (names[i] != null && Objects.equals(names[i], name)) {
                search[count++] = names[i];
                System.out.println("已找到该客户并添加到新名单里");
            }
            else {
                System.out.println("没有找到该客户！");
            }
        }
        return search;
    }
}

class CustomerTest{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        CustomerBiz customerBiz = new CustomerBiz();
        System.out.println("******1.新增客户姓名*******");
        System.out.println("******2.更新客户姓名*******");
        System.out.println("******3.客户姓名排序*******");
        System.out.println("******4.删除客户姓名*******");
        System.out.println("******5.按指定范围查找客户姓名*******");
        loop1:
        while (true) {
            System.out.print("请输入功能(输入0退出程序)：");
            int num = input.nextInt();
            switch (num) {
                case 1 -> {
                    System.out.print("请输入新增客户姓名：");
                    String addName = input.next();
                    if(customerBiz.addName(addName))
                        System.out.println("添加成功！");

                }
                case 2 -> {
                    System.out.println("请输入需要更新的客户姓名");
                    String oldName = input.next();
                    System.out.println("请输入新客户名：");
                    String newName = input.next();
                    if (customerBiz.updateName(oldName,newName))
                        System.out.println("更新成功！");
                }
                case 3 -> customerBiz.sortName(customerBiz.names);
                case 4 -> {
                    System.out.println("请输入需要删除的客户姓名：");
                    String deleteName = input.next();
                    if (customerBiz.deleteName(deleteName))
                        System.out.println("删除成功！");
                }
                case 5 -> {
                    System.out.println("请输入起始序号范围：");
                    int start = input.nextInt();
                    System.out.println("请输入结束序号范围：");
                    int end = input.nextInt();
                    System.out.println("请输入需要查找的客户姓名：");
                    String searchName = input.next();
                    String[] strings = customerBiz.searchName(start,end,searchName);
                    System.out.println(Arrays.toString(strings));
                }
                case 0 -> {
                    break loop1;
                }
            }
        }
    }
}
