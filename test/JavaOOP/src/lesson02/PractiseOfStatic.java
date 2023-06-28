package lesson02;

public class PractiseOfStatic {
    private String name;
    private int age;
    private static int count;

    public PractiseOfStatic(String name, int age) {
            count++;
            System.out.println("您已经创建了"+count+"个对象");
            count();
            this.setName(name);
            this.setAge(age);
    }

    public static void count() {
        if (count >= 5) {
            System.out.println("共"+count+"个学生，可以开班了");
        }
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

    public void showInfo() {
        System.out.println("姓名："+getName()+",年龄："+getAge());
    }

    public static void main(String[] args) {
        PractiseOfStatic s1 = new PractiseOfStatic("张三",18);
        PractiseOfStatic s2 = new PractiseOfStatic("李四",19);
        PractiseOfStatic s3 = new PractiseOfStatic("王五",15);
        PractiseOfStatic s4 = new PractiseOfStatic("赵六",17);
        PractiseOfStatic s5 = new PractiseOfStatic("七七",20);
        s1.showInfo();
        s2.showInfo();
        s3.showInfo();
        s4.showInfo();
        s5.showInfo();
    }
}
