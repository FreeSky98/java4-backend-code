import java.util.Scanner;

public class InsertEle {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] scores = new int[] {99,85,82,63,60,0};//按顺序排列的数组
        int index = scores.length - 1;//定义下标监视器
        System.out.print("请输入新成绩:");
        int number = input.nextInt();

        //遍历数组
        for (int i = 0; i < scores.length; i++)
            if (number > scores[i]) { //找到插入位置的下标
                index = i;//下标赋值给index
                break;
            }
        System.out.println("待插入元素位置:" + index);
        for (int i = scores.length - 1; i > index; i--) {
            scores[i] = scores[i - 1];//将前一个元素后移
        }
        scores[index] = number;//插入
        for (int score : scores) System.out.println(score);//打印新数组
    }
}
