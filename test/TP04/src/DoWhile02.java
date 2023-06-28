public class DoWhile02 {
    public static void main(String[] args) {
        int mul = 1;
        int i = 1;
        do {
            mul *= i;
            i++;
        } while (i <= 6);
        System.out.println("6! = " + mul);
    }
}
