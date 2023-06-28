import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class ArrayCRUD {
    static String[] names = new String[10];// 存储学生姓名列表,String引用类型默认值null
    /*static {
        names[0] = "Tony";
        names[1] = "John";
        names[2] = "Cathy";
        names[3] = "Mike";
        names[4] = "Ben";
        names[5] = "Dannie";
        names[6] = "Mark";
        names[7] = "Rose";
        names[8] = "Kate";
        names[9] = "Taylor";
    }*/
    static Scanner input = new Scanner(System.in);
    public static void insert() {
        System.out.print("请输入学生姓名：");
        String newName = input.next();
        /*
        1.字符串数组是否已满，如果满了，给字符串数组扩容(ObjectName.length + 1)
        2.如果没满呢？  找到位置为null，说明此位置没有存储任何学生姓名
         */
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
        else {
            for (String name:results
                 ) {
                System.out.print(name + "\t");
            }
        }
    }//查询数组中的元素值并输出
    public static void delete() {
        System.out.println("请输入想要删除的学生姓名：");
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
            String updateKeyword = input.next();
            names[index] = updateKeyword;
            for (String name : names) {
                System.out.println(name);
            }
        }
        else {
            System.out.println("想要修改的学生姓名不存在！");
        }
    }//更新修改数组中的元素值
    public static void main(String[] args) { //主方法
        names[0] = "Tony";
        names[1] = "John";
        names[2] = "Cathy";
        names[3] = "Mike";
        names[4] = "Ben";
        names[5] = "Dannie";
        names[6] = "Mark";
        names[7] = "Rose";
        names[8] = "Kate";
        names[9] = "Taylor";

        /*System.out.println("添加前");
        for (String name:names
             ) {
            System.out.println("name = " + name);
        }
        insert();

        System.out.println("添加后");
        for (String name:names
             ) {
            System.out.println("name = " + name);
        }*/
        //search();
        //delete();
        //update();
    }
}
