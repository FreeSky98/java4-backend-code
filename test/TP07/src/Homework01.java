import java.util.Arrays;

public class Homework01 {
    public static void main(String[] args) {
        int[][] oldArr = {
                {1,3,5,7},//00,01,02,03
                {2,4,6,8},//10,11,12,13
                {20,21,8,25},//20,21,22,23
        };
        int[][] newArr = new int[4][3];

        for (int i = 0; i < oldArr.length; i++) {  // i<3 i=0,1,2
            for (int j = 0; j < oldArr[i].length; j++) {  //j<4 j=0,1,2,3
                newArr[j][i] = oldArr[i][j];
            }
        }
        System.out.println("newArr = " + Arrays.deepToString(newArr));
    }
}
