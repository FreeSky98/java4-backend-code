public class NestedForLoop01 {
    //输出格式0时0分0秒
    public static void main(String[] args) {
        for (int i = 1; i <= 24; i++) {
            for (int j = 1; j < 60; j++) {
                for (int k = 1; k < 60; k++) {
                    System.out.printf("%d时%d分%d秒\n",i,j,k);
                }
            }
        }
    }
}
