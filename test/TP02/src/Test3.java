import java.util.Scanner;

public class Test3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("请输入4位会员卡号： ");
        int now =input.nextInt();
        System.out.println("会员卡号是： " + now);

        int thousand = now / 1000;
        int hundred = (now % 1000) / 100;
        int tens = (now % 100) / 10;
        int ones = now % 10;
        System.out.println("千位数： " + thousand);
        System.out.println("百位数 = " + hundred);
        System.out.println("十位数 = " + tens);
        System.out.println("个位数 = " + ones);

        int result = thousand + hundred +tens +ones;
        String a = "会员卡号" + now + "的会员，您中奖了！奖品是MP3！";
        String b ="会员卡号" + now + "的会员，很遗憾您未中奖！";
        String r = result > 20 ? a : b;
        System.out.println(r);
       /* System.out.println("会员卡号" + now + "各位之和：" +result);
        if (result > 20){
            System.out.println("会员卡号" + now + "的会员，您中奖了！奖品是MP3！");
        }
        else {
            System.out.println("会员卡号" + now + "的会员，很遗憾您未中奖！");
        }*/
    }
}
