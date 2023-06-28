public class Test1 {
    public static void main(String[] args) {
        double score = 98.5;
        String name;
        name = "张三";
        char sex = '男';
        boolean marry = false;
        int age = 18;
        double height = 1.80;

        System.out.println("Java课程考试最高分：" + score);
        System.out.println("最高分学员姓名：" + name);
        System.out.println("最高分学员性别：" + sex);
        System.out.println("最高分学员婚姻情况：" + (marry ? "已婚" : "未婚"));
        System.out.println("最高分学员年龄：" + age + "岁");
        System.out.println("最高分学员身高：" + height + "米");
    }
}
