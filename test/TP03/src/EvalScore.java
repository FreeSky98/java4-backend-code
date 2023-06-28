import java.util.Scanner;

public class EvalScore {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入小明的考试成绩： ");
        float score = input.nextFloat();
        if(score < 0 || score > 100) {
            System.err.println("您输入的成绩不合法，请输入0~100之间的分数！");
            return;
        }
        if (score == 100) {
            System.out.println("想干啥干啥");
        }
        else if (score >= 90) {
            System.out.println("看电视、吃零食");
        }
        else if (score > 60) {
            System.out.println("看书，写作业");
        }
        else {
            System.out.println("做家务、洗碗、拖地");
        }
        input.close();
    }
}
