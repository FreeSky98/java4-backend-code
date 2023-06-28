package lesson05.homework03;

public class NetCard implements PCI{
    @Override
    public void send() {
        System.out.println("网卡开始传输数据 ...");
    }
}
