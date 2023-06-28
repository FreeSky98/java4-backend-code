package lesson02;

public class StaticBlock {
    static int num = 100;

    static {
        num += 100;
    }

    static {
        num += 100;
    }

    static {
        num += 100;
    }

    public static void main(String[] args) {
        System.out.println("num = " + num);
    }
}
