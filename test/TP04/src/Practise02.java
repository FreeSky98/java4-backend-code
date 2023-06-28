public class Practise02 {
    public static void main(String[] args) {
        //题目：古典问题：有一对兔子，从出生后第3个月起每个月都生一对兔子，
        //小兔子长到第四个月后每个月又生一对兔子，假如兔子都不死，问每个月的兔子总数为多少？
        //1.程序分析：兔子的规律为数列1,1,2,3,5,8,13,21....
        int a = 1;
        int b = 1;
        //i表示第几项的项数
        for(int i=3;i<=10;i++){
            //n表示第i项的数
            int n = a+b;
            //将第i-1项的值给a
            a = b;
            //将第i项的值给b
            b = n;
            System.out.println("第" +i +"个月生" + n+"小兔纸！");
        }
    }
}
