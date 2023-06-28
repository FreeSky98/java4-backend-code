import java.util.Scanner;

public class Practise01 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("LV购买个数：");
        int Lvs = input.nextInt();
        System.out.print("爱马仕购买个数：");
        int Hermes = input.nextInt();
        System.out.print("香奈儿购买个数：");
        int Chanel = input.nextInt();
        double prise = (Lvs * 35000.0) + (Hermes * 11044.5) + (Chanel * 1535.00);

        if (prise > 50000) {
            prise = prise * 0.7;
        } else {
            prise = prise * 0.9;
        }
        System.out.println("应付金额：" + prise);
    }
}
