package lesson06.demo;

public class Throws {
    //被调用者
    public static int divide(int a ,int b) throws Exception {
        if(b == 0) {
            throw new ArithmeticException("除数为零错误");
        }
        return a / b;
    }

    // 调用者
    public static void main(String[] args) {
        try {
            int retVal =  divide(10,0);
            System.out.println("计算结果为：" + retVal);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("出现错误：" + e.getMessage());
        }
    }
}

