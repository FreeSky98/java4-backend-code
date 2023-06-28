package lesson05.demo.interFace2;

public class Test {
    /**
     * 模拟USB分线器
     */
    public static void hub(USB[] usbs) throws InterruptedException {
        for (USB usb : usbs) {
            usb.service();
        }
    }
    public static void main(String[] args) throws InterruptedException {
        hub(new USB[] {
                new Fan(),
                new Mouse(),
                new FlashDisk()
        });
    }
}
