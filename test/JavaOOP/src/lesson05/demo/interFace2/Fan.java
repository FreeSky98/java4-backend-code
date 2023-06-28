package lesson05.demo.interFace2;

public class Fan implements USB{
    @Override
    public void service() throws InterruptedException {
        System.out.println("插入USB接口，安装驱动中 ...");
        Thread.sleep(5000);
        System.out.println("驱动安装成功，风扇转动 ...");
    }
}
