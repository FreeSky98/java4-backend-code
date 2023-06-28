package lesson05.homework03;

public class VideoCard implements PCI{
    @Override
    public void send() {
        System.out.println("显卡开始传输数据 ...");
    }
}
