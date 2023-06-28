package lesson03.homework01;

public class JavaTeacher extends Teacher{

    public JavaTeacher(String name, char sex, int age, int teachYear, String center) {
        super(name, sex, age, teachYear, center);
    }

    public void teach() {
        System.out.println("打开Eclipse、实施理论课授课");
    }
}
