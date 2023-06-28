import java.util.Scanner;

public class NestedIf {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("请输入您的比赛成绩：");
        double score = input.nextDouble();
        if (score < 10){
            System.out.print("恭喜您进入决赛！请输入性别：");
            String sex = input.next();
            if (sex .equals("男")){
                System.out.println("进入男子组决赛");
            }
            else {
                System.out.println("进入女子组决赛");
            }
        }
        else {
            System.out.println("对不起，您没有进入决赛，再接再厉！");
        }
    }
}
