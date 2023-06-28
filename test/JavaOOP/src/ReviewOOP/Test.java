package ReviewOOP;

public class Test {
    public static void main(String[] args) throws InterruptedException {
        Phone apple = new Phone("苹果手机","14Pro",5499,"远峰蓝");
        String info = apple.showInfo();
        System.out.println("苹果手机信息：\n" + info);
        String message = apple.sendMessage("Hello!", "17844559865");
        System.out.println(message);
        apple.call("17844559865");
    }
}
