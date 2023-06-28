package lesson05.demo.interFace4;

/**
 * 智能手机类
 */
public class SmartPhone extends Phone implements TakePicture,Network,PlayWiring{
    public SmartPhone() {
    }

    public SmartPhone(String brand, String type) {
        super(brand, type);
    }

    @Override
    public void networkConnection() {
        System.out.println("已启动移动网络");
    }

    @Override
    public void sendInfo() {
        System.out.println("发送带图片与文字的信息");
    }

    @Override
    public void call() {
        System.out.println("开始视频通话");
    }

    @Override
    public void play(String content) {
        System.out.println("开始播放视频《"+content+"》");
    }

    @Override
    public void takePictures() {
        System.out.println("咔嚓 ... 拍照");
    }
}
