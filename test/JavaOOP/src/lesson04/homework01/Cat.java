package lesson04.homework01;

public class Cat extends Animal {
    public Cat(String nickname, int age) {
        super(nickname, age);
    }

    @Override
    public void eat() {
        System.out.println("吃鱼");
    }
}
