import java.util.Scanner;

public class PractiseOfArraysTools02 {
    public static void main(String[] args) {
        String[][] phones = new String[3][2];
        Scanner input = new Scanner(System.in);

        for (int i = 0; i < phones.length; i++) {
            for (int j = 0; j < phones[i].length; j++) {
                System.out.println("请输入第"+(i+1)+"个同学的姓名：");
                phones[i][j] = input.next();
                j++;
                System.out.println("请输入第"+(i+1)+"个同学的电话：");
                phones[i][j] = input.next();
            }
        }
        System.out.println("******同学通讯录******");
        for (int i = 0; i < phones.length; i++) {
            for (int j = 0; j < phones[i].length; j++) {
                System.out.print("姓名："+phones[i][j]+"\t");
                j++;
                System.out.println("联系电话："+phones[i][j]+"\t");
            }
        }
    }
}
