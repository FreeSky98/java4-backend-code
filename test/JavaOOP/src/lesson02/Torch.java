package lesson02;

public class Torch {
    private int power;

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        if (power > 0 && power <= 100) {
            this.power = power;
        }
        else {
            System.out.println("电池损耗，请更换电池");
            this.power = 1;
        }
    }
    public void turnOn(){
        System.out.println("手电筒正在发光...");
        try {
            Thread.sleep(10000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        this.power -= 5;
        System.out.println("持续光照10分钟耗电5%的电量，当前电量为："+this.power+"%");
    }
    public void turnOff(){
        System.out.println("关灯，当前电量为："+this.power+"%");
    }
    public void charging(){
        this.power += 10;
        System.out.println("充一次电可获得10%的电量，当前电量为："+this.power+"%");
    }
}

class TorchTest {
    public static void main(String[] args) {
        Torch torch = new Torch();
        torch.setPower(90);
        torch.charging();
        System.out.println("当前电量为："+torch.getPower()+"%");
        torch.turnOn();
        torch.turnOff();
    }
}
