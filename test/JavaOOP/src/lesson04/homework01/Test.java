package lesson04.homework01;

public class Test {
    public static void main(String[] args) {
        Animal animal = new Cat("小花",4);
        System.out.println(animal);
        animal.eat();

        animal = new Dog("大黄",5);
        System.out.println(animal);
        animal.eat();
    }
}
