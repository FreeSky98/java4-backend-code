public class Op1 {
    public static void main(String[] args) {
        int a = 4321;
        int b = 1234;
        int result;
        result = a + b;
        /*
         String.format(格式化字符串,变量列表)

         常用转换符如下：
         %d    --------------------  int
         %s    --------------------  String
         %c    --------------------  char
         %b    --------------------      boolean
         %f/%.2f    --------------------  double/float
         %%         --------------------  %
         %n            -----------------  换行符
         */
        String str = String.format("%d + %d = %d %n",a,b,result);
        System.out.println("str = " + str);

        result = a - b;
        str = String.format("%d - %d = %d %n",a,b,result);
        System.out.println("str = " + str);

        result = a * b;
        str = String.format("%d * %d = %d %n",a,b,result);
        System.out.println("str = " + str);

        result = a / b;
        str = String.format("%d / %d = %d %n",a,b,result);
        System.out.println("str = " + str);

        result = a % b;
        str = String.format("%d %% %d = %d %n",a,b,result);
        System.out.println("str = " + str);

        int x = 3;
        int y = 4;
        int z = x++ + ++x + --y + y--;//3 + 4 + 3 + 4 = 14
        System.out.println("z = " + z);
    }
}

