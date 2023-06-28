package lesson01;

public class Addition {
    public int add(int a,int b) {
        return a + b;
    }
    public long add(long a, long b) {
        return a + b;
    }
    public float add(float a,float b) {
        return a + b;
    }
    public double add(double a,double b) {
        return a + b;
    }
    public String add(String a,String b) {
        return a + b;
    }
}

class AdditionTest {
    public static void main(String[] args) {
        Addition addition = new Addition();
        System.out.println("addition.add(1,1) = " + addition.add(1, 1));
        System.out.println("addition.add(1111111111,111111111) = " + addition.add(1111111111, 111111111));
        System.out.println("addition.add(1.11,1.11) = " + addition.add(1.11, 1.11));
        System.out.println("addition.add(\"我爱\",\"敲代码\") = " + addition.add("我爱", "敲代码"));
    }
}