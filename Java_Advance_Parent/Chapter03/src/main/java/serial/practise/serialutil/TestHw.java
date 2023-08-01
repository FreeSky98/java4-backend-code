package serial.practise.serialutil;

import java.io.*;
import java.util.ArrayList;

public class TestHw {
    public static void main(String[] args) {
        File file = null;
        try {
            file = new File("a.dat");
            if (!file.exists()) {
                file.createNewFile();
            } else {
                // TODO 序列化
                // todo 使用序列化将对象写入文件中
                FileOutputStream fos = new FileOutputStream(file);
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                // 将内容写入
                oos.writeObject(new StudentHw("James",23));
                oos.writeObject(new StudentHw("Tom",21));

                oos.writeObject(new TeacherHw("张老师",40,12000));
                oos.writeObject(new TeacherHw("周老师",48,10000));


                try {
                    // TODO 反序列化
                    FileInputStream fis = new FileInputStream(file);
                    ObjectInputStream ois = new ObjectInputStream(fis);
                    ArrayList<Object> sList = new ArrayList<>();
                    ArrayList<Object> tList = new ArrayList<>();
                    Object o = null;
                    System.out.println("可用字节数 （before）："  + fis.available() );
                    // 需要在外部创建一个Object对象，赋值为null
                    while (fis.available() > 0) {  // todo 代表文件中还有内容
                        // 读取内容，该行代码不能放置最后，不然最后输出结果会少一行数据
                        o = ois.readObject();

                        if (o instanceof StudentHw) {
                            sList.add(o);
                            System.out.println("学生:" + o);
                        } else if (o instanceof TeacherHw) {
                            tList.add(o);
                            System.out.println("老师:" + o);
                        }
                    }
                    System.out.println("可用字节数："  + fis.available() );
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class StudentHw {
    private String name;
    private int age;

    public StudentHw(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "StudentHw{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

class TeacherHw {
    private String name;
    private int age;
    private double salary;

    public TeacherHw(String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "TeacherHw{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                '}';
    }
}
