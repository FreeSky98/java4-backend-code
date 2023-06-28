package lesson03.homework02;

public class Tiger extends Animal {
    public Tiger(String name) {
        super(name);
    }

    public void eat() {
        System.out.println(this.getName() +"吃肉");
    }
}
