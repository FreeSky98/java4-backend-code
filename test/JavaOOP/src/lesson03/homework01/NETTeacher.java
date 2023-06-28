package lesson03.homework01;

public class NETTeacher extends Teacher{
    public NETTeacher(String name, char sex, int age, int teachYear, String center) {
        super(name, sex, age, teachYear, center);
    }
    public void teach() {
        System.out.println("打开Visual Studio 2017、实施理论课授课");
    }
}
