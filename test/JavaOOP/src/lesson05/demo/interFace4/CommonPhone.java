package lesson05.demo.interFace4;

public class CommonPhone extends Phone implements PlayWiring{

    public CommonPhone() {
    }

    public CommonPhone(String brand, String type) {
        super(brand, type);
    }

    @Override
    public void sendInfo() {
        System.out.println("发送文字信息");
    }

    @Override
    public void call() {
        System.out.println("开始语音通话");
    }

    @Override
    public void play(String content) {
        System.out.println("开始播放音乐《"+content+"》");
    }
}
