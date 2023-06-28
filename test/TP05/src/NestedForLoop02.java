public class NestedForLoop02 {
    public static void main(String[] args) {
        for (int i = 1; i <= 5; i++) {
            //控制列数
            for (int j = 1; j <= 5; j++) {
                System.out.print("*");
            }//控制每行的星号
            System.out.println();//每行换行
        }
    }
}

class NestedForLoop02_2 {
    public static void main(String[] args) {
        for (int i = 1; i <= 5; i++) {
            //控制列数
            for (int j = 1; j <= 5 - i; j++) {
                System.out.print(" ");
            }
            //控制打印空格
            for (int k = 1; k <= 5; k++) {
                System.out.print("*");
            }//控制每行的星号
            System.out.println();//每行换行
        }
    }
}

class NestedForLoop02_3 {
    public static void main(String[] args) {
        for (int i = 1; i <= 5; i++) {
            //控制列数
            for (int j = 1; j <= 5 - i; j++) {
                System.out.print(" ");
            }//控制打印空格
            for (int k = 1; k <= (2 * i) - 1 ; k++) {
                System.out.print("*");
            }//控制每行的星号
            System.out.println();//每行换行
        }
    }
}

class NestedForLoop02_4 {
    public static void main(String[] args) {
        for (int i = 1; i <= 5; i++) {
            //控制列数
            for (int j = 1; j <= 5 - i; j++) {
                System.out.print(" ");
            }//控制打印空格
            for (int k = 1; k <= (2 * i) - 1 ; k++) {
                System.out.print("*");
            }//控制每行的星号
            System.out.println();//每行换行
        }
        for (int i = 4; i > 0; i--) {
            //控制列数
            for (int j = 5 - i; j > 0; j--) {
                System.out.print(" ");
            }//控制打印空格
            for (int k = 2 * i - 1; k > 0 ; k--) { //i = 4 k = 7
                System.out.print("*");
            }//控制每行的星号
            System.out.println();//每行换行
        }
    }
}
class NestedForLoop02_9X9Type01 {
    public static void main(String[] args) {
        System.out.println("九九乘法表");
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= 9; j++) {
                System.out.printf("%d * %d = %d\t",j,i,i * j);
                if (j == i) break;
            }
            System.out.println();
        }
    }
}

class NestedForLoop02_9X9Type02 {
    public static void main(String[] args) {
        System.out.println("九九乘法表02");
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j + "*" + i + "=" + i * j + "\t");
            }
            System.out.println();
        }
    }
}
