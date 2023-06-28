package lesson03.homework01;

public class TeacherTest {
    public static void main(String[] args) {
        JavaTeacher j1 = new JavaTeacher("张三",'男',24,2,"北大青鸟科海校区");
        NETTeacher n1 = new NETTeacher("李四",'女',25,3,"北大青鸟科海校区");
        j1.introduce();
        j1.teach();
        n1.introduce();
        n1.teach();
    }
}
