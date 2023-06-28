package lesson03.homework02;

public class AnimalTest {
    public static void main(String[] args) {
        Rabbit r1 = new Rabbit("小兔子");
        Tiger t1 = new Tiger("大老虎");
        r1.eat();
        r1.sleep();
        t1.eat();
        t1.sleep();
    }
}
