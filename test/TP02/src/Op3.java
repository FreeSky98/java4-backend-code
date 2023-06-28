public class Op3 {
    public static void main(String[] args) {
        int a = 5;//0101
        System.out.println(Integer.toBinaryString(5));

        int b = 6;//0110
        System.out.println(Integer.toBinaryString(6));

        int c = a & b;
        /*
          0101
        & 0110
         -----------
          0100
        */
        System.out.println("c = " + c);
        c = a | b;
        /*
          0101
        | 0110
        ------------
          0111
         */
        System.out.println("c = " + c);
        c = a ^ b;
        /*
          0101
        ^ 0110
        ------------
          0011
         */
        System.out.println("c = " + c);
        int f = 20;
        int d = ~f;
        System.out.println("d = " + d);

        int g;
        g = 1 << 4;//1 * 2^4 = 16 左移是乘
        System.out.println("g = " + g);

        int h;
        h = 16 >> 2;//16 / 2^2 = 4 右移是除
        System.out.println("h = " + h);
    }
}
