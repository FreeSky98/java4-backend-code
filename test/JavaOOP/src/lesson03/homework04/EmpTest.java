package lesson03.homework04;

public class EmpTest {
    public static void main(String[] args) {
        SE s1 = new SE("张三","合肥市蜀山区","17355440123","abc@qq.com","督察组",18000,"2020年4月5日","唱歌","P10");
        PM pm = new PM("李四","合肥市包河区","15278546523","zxc@qq.com","督察组",23000,"2018年5月10日","5");
        s1.introduce();
        pm.introduce();
    }
}
