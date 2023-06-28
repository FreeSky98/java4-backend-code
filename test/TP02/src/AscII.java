public class AscII {
    public static void main(String[] args){
        char me = '我';
        char love = '爱';
        char you = '你';
        int b; // 29233 - 爱
        b = love;
        int c; // 20320 - 你
        c = you;
        System.out.println("a = " + (int) me);
        System.out.println("b = " + b);
        System.out.println("c = " + c);
        System.out.println("请记住如下ASCII码值");
        System.out.println("十进制\t\t字符");
        for (char i = 0; i < 128; i++) {
            int j;
            j = i;
            if(i >= 'a' && i <= 'z' || i >= 'A' && i <= 'Z' || i >= '0' && i <= '9' || i == ' ') {
                System.out.println(j + "\t\t\t " + i);
            }
        }
    }
}
