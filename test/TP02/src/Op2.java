public class Op2 {
    public static void main(String[] args) {
        int a = 3;
        int b = 4;
        boolean result = a == --b && a != --b;
        System.out.println("a = " + a + "\t" + "b = " + b + "\t" + "result = " + result);
    }
}
