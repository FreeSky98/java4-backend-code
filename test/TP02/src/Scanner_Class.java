import java.util.Scanner;

public class Scanner_Class {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        /*input.useDelimiter(" ");
        System.out.print("请输入数据：");
        String str = input.nextLine();
        String[] vars = str.split(" ");
        System.out.println("str = " + str);
        System.out.println(Arrays.toString(vars));
        hasNext()方法判断当前是否有输入，当键盘有输入后执行循环*/
        System.out.print("请输出您的年龄：");
        while (input.hasNext()){
            if (!input.hasNextInt()){
                System.out.println("您输入的不是有效数字！");
                input = new Scanner(System.in);
            }
            else {
                int age = input.nextInt();
                System.out.println("您输入的年龄是 " + age +"岁");
            }
        }
    }
}
