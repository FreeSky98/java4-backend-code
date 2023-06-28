import java.util.Arrays;
import java.util.Scanner;

public class Homework01 {
    static String[] names = new String[8];// 存储学生姓名列表
    static Scanner input = new Scanner(System.in);
    public static void insert() {
        System.out.print("请输入想要插入的新学生姓名：");
        String newName = input.next();
        boolean isFull = true;//表示已满，false表示未满
        int index = -1;
        for (int i = 0; i < names.length; i++) {
            if (names[i] == null) {
                isFull = false;
                index = i;
                break;
            }
        }
        if (isFull) {
            System.out.println("字符串数组已满！");
        }
        else {
            names[index] = newName;
            System.out.println("已成功将" + newName + "添加到字符串数组中！");
        }
        System.out.println("添加后");
        for (String name:names
        ) {
            System.out.println("name = " + name);
        }
    }//向数组中插入元素值
    public static void search() {
        // 存储搜索结果字符串数组
        System.out.print("请输入要查找的学生姓名(支持模糊查询):");
        String keyword = input.next();
        int k = 0;
        String[] results = new String[0];
        for (String name:names
        ) {
            if (name != null && name.toLowerCase().contains(keyword.toLowerCase())) {
                results = Arrays.copyOf(results,results.length + 1);
                results[k++] = name;
            }
        }
        System.out.println("搜索的结果是：");
        if (results.length == 0) {
            System.out.println("没有找到符合条件的学生姓名列表!");
        }
        else System.out.println(Arrays.toString(results));
    }//查询数组中的元素值并输出
    public static void delete() {
        System.out.print("请输入想要删除的学生姓名：");
        String keyword = input.next();
        int index = -1;//监视器，与数组中的下标区分开
        for (int i = 0; i < names.length; i++) { //遍历数组
            if (names[i] != null && names[i].equalsIgnoreCase(keyword)) { //如果等于删除的字符
                index = i;//标记
                break;
            }
        }
        if (index != -1) { //如果找到要删除的字符
            for (int i = index; i < names.length - 1; i++) { //后一位的数据前移一位
                names[i]= names[i + 1];
            }
            names[names.length - 1] = null;//最后一位的数据变成空
        }
        else {
            System.out.println("没有您要删除的姓名！");
        }
        for (String name : names) {
            System.out.println(name);
        }
    }//删除数组中的元素值
    public static void update() {
        System.out.print("请输入想要修改的学生姓名：");
        String keyword = input.next();
        int index = -1;
        for (int i = 0; i < names.length; i++) {
            if (names[i] != null && keyword.equalsIgnoreCase(names[i])) {
                index = i;
                break;
            }
        }
        if (index != -1) {
            System.out.print("请输入修改后的学生姓名：");
            String newName = input.next();
            names[index] = newName;
            for (String name : names) {
                System.out.println(name);
            }
        }
        else {
            System.out.println("想要修改的学生姓名不存在！");
        }
    }//更新修改数组中的元素值
    public static void main(String[] args) { //主方法
        names[0] = "James";
        names[1] = "Tom";
        names[2] = "John";
        names[3] = "Peter";
        names[4] = "Rose";
        names[5] = "Alice";
        names[6] = "Mic";
        names[7] = "Mike";

        delete();
        insert();
        search();
        update();
    }
}

