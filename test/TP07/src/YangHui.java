public class YangHui {
    public static void main(String[] args) {
        int[][] matrix = new int[10][];
        for (int i = 0; i < matrix.length; i++) { // i < 10  i = (0~9)
            matrix[i] = new int[i + 1];//每一行比上一行多一位数，第一行是1
            matrix[i][0] = 1;//第一个数是1
            matrix[i][i] = 1;//最后一个数是1
            for (int j = 1; j < matrix[i].length - 1; j++) { //?
                matrix[i][j] = matrix[i - 1][j] + matrix[i - 1][j - 1];//公式
            }
        }
        //打印三角形
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 9; j > i; j--) {
                System.out.print("  ");
            }
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print("  " + matrix[i][j] + "  ");
            }
            System.out.println();
        }
    }
}
