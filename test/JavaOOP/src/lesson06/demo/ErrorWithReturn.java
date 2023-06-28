package lesson06.demo;

public class ErrorWithReturn {

    public static int test() {
        int a = 0;
        try{
            a = 1;
            if(true) {
                throw new RuntimeException("模拟异常发生....");
            }
            System.out.println("try块 a = " + a);

            return a;
        }
        catch (Exception e){
            a = -1;
            System.out.println("catch块 a = " + a);
            return a;
        }finally {
            //a = 2;
            System.out.println("finally块 a = " + a);
            //return a;
        }
    }

    public static void main(String[] args) {
        int val = test();
        System.out.println("方法返回值是： val = " + val);
    }
}
