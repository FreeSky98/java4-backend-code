package lesson01;

import java.util.Scanner;

public class StudentBiz {
    //学生姓名数组
    String[] names = new String[6];

    /**
     * 添加学生姓名
     *
     * @param newName 新生姓名
     * @return 返回true表示添加成功，否则失败
     */

    public boolean addName(String newName) {
        for (int i = 0; i < names.length; i++) {
            if (names[i] == null) {
                names[i] = newName;
                return true;
            }
        }
        return false;
    }

    /**
     * 修改学生姓名
     *
     * @param oldName 待修改学生姓名
     * @param newName 已修改学生姓名
     * @return 返回true表示添加成功，否则失败
     */

    public boolean editName(String oldName, String newName) {
        for (int i = 0; i < names.length; i++) {
            if (names[i] != null && oldName.equals(names[i])) {
                names[i] = newName;
                return true;
            }
        }
        return false;
    }

    /**
     * 删除学生姓名
     * * @param delName 待删除学生姓名
     * * @return 返回true表示删除成功，否则删除失败
     */

    public boolean removeName(String delName) {
        for (int i = 0; i < names.length; i++) {
            if (names[i] != null && delName.equals(names[i])) {
                names[i] = null;
                return true;
            }
        }
        return false;
    }

    /**
     * 按指定范围查找学生姓名
     *
     * @param begin 开始位置
     * @param end   结束位置
     * @param name  待查找的学生姓名
     * @return 返回true表示查找成功，否则查找失败
     */

    public boolean find(int begin, int end, String name) {
        for (int i = begin - 1; i < end; i++) {
            if (names[i] != null && names[i].equals(name)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        StudentBiz studentBiz = new StudentBiz();
        Scanner scanner = new Scanner(System.in);
        System.out.println("******1.添加学生姓名*******");
        System.out.println("******2.修改学生姓名*******");
        System.out.println("******3.删除学生姓名*******");
        System.out.println("******4.按范围查找学生*******");
        System.out.println("******5.退出系统*******");
        loop1:
        while (true) {
            System.out.println("输入需要执行的功能：");
            int a = scanner.nextInt();
            switch (a) {
                case 1:
                    System.out.println("输入要添加的学生姓名");
                    String addName = scanner.next();
                    if (studentBiz.addName(addName))
                        System.out.println("添加成功");
                    break;
                case 2:
                    System.out.println("输入要修改的学生旧姓名");
                    String oldName = scanner.next();
                    System.out.println("输入要修改的学生新姓名");
                    String newName = scanner.next();
                    if (studentBiz.editName(oldName, newName))
                        System.out.println("修改成功");
                    break;
                case 3:
                    System.out.println("输入要删除的学生姓名");
                    String delName = scanner.next();
                    if (studentBiz.removeName(delName))
                        System.out.println("删除成功");
                    break;
                case 4:
                    System.out.println("输入查询的开始位置");
                    int start = scanner.nextInt();
                    System.out.println("输入查询的结束位置");
                    int end = scanner.nextInt();
                    System.out.println("输入查询的学生姓名");
                    String findName = scanner.next();
                    if (studentBiz.find(start, end, findName)) {
                        System.out.println(findName + "被查找到啦！");
                    } else {
                        System.out.println("查无此人！");
                    }
                    break;
                case 5:
                    break loop1;
            }
        }
        System.out.println("退出系统");
    }
}

