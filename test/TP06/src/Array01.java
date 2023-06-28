public class Array01 {
    public static void main(String[] args) {
        /*int[] scores = new int[3];
        scores[0] = 80;
        scores[1] = 85;
        scores[2] = 90;*/
        int[] scores = {80,85,90,78,86};
        int sum = 0;
        double avg;
        for (int i = 0; i < scores.length; i++) { //普通for循环
            sum += scores[i];
        }

        /*for (int score : scores) { //增强for循环:      数据类型 局部变量 : 数组名或集合名
            sum += score;
        }*/
        avg = (double) sum / scores.length; //数据名.length动态获取数组长度
        System.out.println("平均分：" + avg);
    }
}
