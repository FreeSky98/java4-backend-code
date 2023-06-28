import java.util.Scanner;

public class Reg {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("welcome!");
        System.out.println("Please input your username!");
        String username = input.next();
        System.out.println("Please input your age!");
        int age = input.nextInt();
        System.out.println("Please input your gender!");
        char gender = input.next().charAt(0);
        System.out.println("Please input your eyesight!");
        float eyesight = input.nextFloat();

        System.out.println("username = " + username);
        System.out.println("age = " + age);
        System.out.println("gender = " + gender);
        System.out.println("eyesight = " + eyesight);
    }
}
