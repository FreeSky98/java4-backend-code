package lesson03.homework02;

public class Rabbit extends Animal {
    public Rabbit(String name) {
        super(name);
    }

    public void eat() {
        System.out.println(this.getName() +"吃草");
    }
}
