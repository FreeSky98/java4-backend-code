package lesson06.demo;

public class Error {
    public static void main(String[] args) {
        int result = 0;
        try {
            int num1 = Integer.parseInt(args[0]);
            int num2 = Integer.parseInt(args[1]);
            result = num1/ num2;
        } catch (NumberFormatException ex) {
            System.out.println("出现错误：你输入的不是有效的整数。");
        } catch (ArrayIndexOutOfBoundsException ex) {
            System.out.println("出现错误：数组索引超出有效范围。");
        } catch (ArithmeticException ex) {
            System.out.println("出现错误：除数不能为零。");
        } catch (Exception ex) {
            System.out.println("出现错误：未知错误，错误信息为：" + ex.getMessage());
        }
        System.out.println("运算结果是：" + result);
    }
}
