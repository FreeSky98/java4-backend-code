public class Practise01 {
    public static void main(String[] args) {
        int start = 1000;
        int end = 9999;
        int count = 0;
        do {
            int ones = start % 10 ;
            int tens = start / 10 % 10;
            int hundreds = start / 100 % 10;
            int thousands = start / 1000;

            if (ones == tens && hundreds == thousands && thousands != tens) {
                count++;
                System.out.print(start + "\t");
                if (count % 10 == 0) { //每10个数字换一行
                    System.out.print("\n");
                }
            }
            start++;
        } while (start <= end);
    }
}
