package lesson01;

public class Calculator {
    public int add(int a,int b) {
        return a + b;
    }
    public int subtract(int a,int b) {
        return a - b;
    }
    public int multiply(int a,int b) {
        return a * b;
    }

    public double divide(double a,double b) {
        if (b == 0) {
            throw new ArithmeticException("除数不能为0！");
        }
        return a / b;
    }
    public double impression(double a,double b) {
        if (b == 0) {
            throw new ArithmeticException("除数不能为0！");
        }
        return a % b;
    }
    public int factorial(int a) {
        int sum = 1;
        for (int i = 1; i <= a; i++) {
            sum *= i;
        }
        return sum;
    }
    public int square(int a) {
        return a * a;
    }
    public int cube(int a) {
        return a * a * a;
    }
    public double pow(double a,int b) {
        int sum = 1;
        for (int i = 1; i <= b; i++) {
            sum *= a;
        }
        return sum;
    }
}

class CalculatorTest {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        System.out.println("calculator.add(2,1) = " + calculator.add(2, 1));
        System.out.println("calculator.subtract(2,1) = " + calculator.subtract(2, 1));
        System.out.println("calculator.multiply(2,1) = " + calculator.multiply(2, 1));
        System.out.println("calculator.divide(4,2) = " + calculator.divide(4, 2));
        System.out.println("calculator.impression(4,3) = " + calculator.impression(4, 3));
        System.out.println("calculator.factorial(5) = " + calculator.factorial(5));
        System.out.println("calculator.square(5) = " + calculator.square(5));
        System.out.println("calculator.cube(5) = " + calculator.cube(5));
        System.out.println("calculator.power(2,5) = " + calculator.pow(2, 5));
    }
}
