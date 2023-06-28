package lesson05.homework04;

public class Student implements Comparable{
    //定义学生类，包括学号、姓名、年龄和分数，实现Comparable接口，按照分数倒序排列；
    private String stuNumber;
    private String name;
    private int age;
    private int score;

    public Student(String stuNumber, String name, int age, int score) {
        this.stuNumber = stuNumber;
        this.name = name;
        this.age = age;
        this.score = score;
    }

    public String getStuNumber() {
        return stuNumber;
    }

    public void setStuNumber(String stuNumber) {
        this.stuNumber = stuNumber;
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

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public int compareTo(Object obj) {
        if (!(obj instanceof Student other)) {
            throw new IllegalArgumentException("传入的对象不是学生对象！");
        }
        if (this.score > other.score) {
            return 1;
        } else if (this.score < other.score) {
            return -1;
        } else {
            return 0;
        }
    }
    public String toString() {
        return "学号："+getStuNumber()+"，姓名："+getName()+"，年龄："+getAge()+"，分数："+getScore();
    }
}
