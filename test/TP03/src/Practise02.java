import java.util.Scanner;

public class Practise02 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("我行我素购物管理系统 > 幸运抽奖");
        int random = (int)(Math.random()*10);//Math.random()是double类型的随机小数，取值在0~1之间
        System.out.println("作弊数字" + random);

        System.out.println("请输入会员卡号：");
        int num = input.nextInt();
        int hundred = (num / 100) % 10;
        if (num >= 1000 && num <=9999) {
            if (hundred == random) {
                System.out.println(num + "号客户是幸运账户，获精美MP3一个！");
            }
            else {
                System.out.println(num + "号客户，谢谢您的支持！");
            }
        }
        else {
            System.err.println("请输入有效的会员卡号！");
        }
        input.close();
    }
}
