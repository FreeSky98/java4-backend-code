package lesson05.demo.interFace1;

public class Master {
    public void feed(Animal animal) {
        animal.eat();
    }

    public static void main(String[] args) {
        Master m1 = new Master();
        m1.feed(new Cat());
        m1.feed(new Dog());
        m1.feed(new Monkey());
        m1.feed(new Lion());
    }
}
