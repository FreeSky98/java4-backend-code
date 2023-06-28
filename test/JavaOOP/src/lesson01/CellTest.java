package lesson01;

public class CellTest {
    public static void main(String[] args) {
        CellPhone cellPhone = new CellPhone();
        cellPhone.brand = "iPhone";
        cellPhone.sp = 15;
        cellPhone.checkPower();
        cellPhone.playMusic();
        cellPhone.charge();
    }
}
class CellPhone {
    String brand;
    int sp;//剩余电量
    public void checkPower() {
        System.out.println("品牌："+ this.brand);
        System.out.println("电量："+ this.sp + "%");
        if (sp < 20) {
            System.out.println("电量过低，请充电");
        }
    }
    public String downloadMusic() {
        return ("晴天");
    }
    public void playMusic() {
        String songName = this.downloadMusic();
        System.out.println("正在播放<<" + songName +">>");
    }
    public void charge() {
        Cell charge = new Cell();
        charge.brand = "苹果";
        charge.getPower();
    }
}
class Cell {
    String brand = "苹果";
    public void getPower() {
        //this关键字：表示当前对象的引用
        System.out.println(this.brand + "开始充电");
    }
}


