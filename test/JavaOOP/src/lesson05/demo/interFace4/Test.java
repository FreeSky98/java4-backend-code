package lesson05.demo.interFace4;

public class Test {
    public static void main(String[] args) {
        CommonPhone cp = new CommonPhone("索尼爱立信","6502c");
        cp.info();
        cp.play("热雪");
        cp.sendInfo();
        cp.call();

        SmartPhone sp = new SmartPhone("HTC","I9100");
        sp.info();
        sp.networkConnection();
        sp.play("小时代");
        sp.takePictures();
        sp.sendInfo();
        sp.call();

    }
}
