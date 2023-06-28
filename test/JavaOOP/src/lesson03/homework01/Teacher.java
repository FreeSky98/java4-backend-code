package lesson03.homework01;

public class Teacher {
    private String name;
    private char sex;
    private int age;
    private int teachYear;//教龄
    private String center;//所在中心

    public Teacher(String name, char sex, int age, int teachYear, String center) {
        this.name = name;
        if (sex == '男' || sex == '女') {
            this.sex = sex;
        } else {
            System.out.println("性别必须是男或者女");
        }
        this.age = age;
        this.teachYear = teachYear;
        this.center = center;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getTeachYear() {
        return teachYear;
    }

    public void setTeachYear(int teachYear) {
        this.teachYear = teachYear;
    }

    public String getCenter() {
        return center;
    }

    public void setCenter(String center) {
        this.center = center;
    }

    public void teach() {
        System.out.println("打开XXX、实施理论课授课");
    }
    public void introduce() {
        System.out.println("大家好，我的名字是："+getName()+"，性别"+getSex()+"，年龄"+getAge()+"岁，教龄"+getTeachYear()+"年，所在中心"+getCenter());
    }
}
