package lesson05.homework03;

public class AudioCard implements PCI{
    @Override
    public void send() {
        System.out.println("声卡开始传输数据 ...");
    }
}
