package lesson04.homework01;

public class Dog extends Animal {
    public Dog(String nickname, int age) {
        super(nickname, age);
    }

    @Override
    public void eat() {
        System.out.println("吃骨头");
    }
}
