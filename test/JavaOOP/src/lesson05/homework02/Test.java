package lesson05.homework02;

public class Test {
    public static void main(String[] args) {
        Animal rabbit = new Rabbit("美人","黑色","哺乳类");
        Animal frog = new Frog("大兵","绿色","非哺乳类");
        System.out.println(rabbit.showInfo());
        System.out.println("------------------------------------------");
        System.out.println(frog.showInfo());
    }
}
