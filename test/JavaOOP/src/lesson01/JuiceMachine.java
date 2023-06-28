package lesson01;

public class JuiceMachine {
    String brand;
    double price;

    public void juicing(String fruit1,String fruit2,String fruit3,int num) {
        System.out.println("按下启动按钮，" + this.brand + "品牌,价格为" + this.price+ "的榨汁机正在榨汁,请稍后 ...");
        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("榨汁机已榨汁结束,输出" + num +"杯" + fruit1 + "汁");
        System.out.println("榨汁机已榨汁结束,输出"+ num +"杯" + fruit2 + "汁");
        System.out.println("榨汁机已榨汁结束,输出"+ num +"杯" + fruit3 + "汁");
    }
}

class JuiceMachineTest{
    public static void main(String[] args) {
        JuiceMachine joyoung = new JuiceMachine();
        joyoung.brand = "九阳";
        joyoung.price = 79;
        joyoung.juicing("西瓜","苹果","香蕉",3);
    }
}

