package lesson05.homework01;

public class Divide implements ICalculator{
    @Override
    public int calculate(int n, int m) {
        if (m == 0) {
            System.err.println("除数不能为0！");
        }
        return n / m;
    }
}
