public class Practise01 {
    public static void main(String[] args) {
        int sum = 0;
        for (int i = 1; i <= 100; i++) {
            sum += i;
        }
        System.out.println("1加到100的值是：" + sum);
    }
}

class Practise02 {
    public static void main(String[] args) {
        int count =0;
        //1.有1、2、3、4个数字，能组成多少个互不相同且无重复数字的三位数？都是多少？
        for (int i = 1; i <= 4; i++) {
            for (int j = 1; j <= 4; j++) {
                for (int k = 1; k <= 4; k++) {
                    if (i != j && j != k && i != k) {
                        System.out.println(i * 100 + j * 10 + k);
                        count++;
                    }
                }
            }
        }
        System.out.print("能组成"+ count + "个互不相同且无重复数字的三位数");
    }
}