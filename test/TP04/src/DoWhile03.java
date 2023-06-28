public class DoWhile03 {
    public static void main(String[] args) {
        int row = 1;//条目
        int f;//华氏温度
        int c = 0;//摄氏温度
        System.out.println("对照表");
        System.out.println("摄氏温度\t\t华氏温度");
        do {
            System.out.println("-------------------");
            f = (int)(c * 9 / 5.0 + 32);//转换公式
            System.out.println(c + "\t\t\t" + f);

            c += 20;
            row++;
        } while (row <= 10 && c <= 250);
        System.out.println("程序执行结束！");
    }
}
