package lesson04.homework01;

/**
 * 动物类
 */
public class Animal {
    private String nickname;//昵称
    private int age;

    public Animal(String nickname, int age) {
        this.nickname = nickname;
        this.age = age;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    public void eat() {

    } //吃成员方法
    public String toString() {
        return "昵称："+getNickname()+",年龄："+getAge()+"岁";
    }
}
