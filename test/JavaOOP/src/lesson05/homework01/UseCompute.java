package lesson05.homework01;

public class UseCompute {
    public void useCom(ICalculator calc,int one,int two) {
        System.out.println("运算结果：" + calc.calculate(one, two));
    }
}
