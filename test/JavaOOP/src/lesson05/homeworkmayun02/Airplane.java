package lesson05.homeworkmayun02;

public class Airplane extends Weapon{
    @Override
    public void attack() {
        System.out.println("战斗机正在攻击敌方目标 ...");
    }

    @Override
    public void move() {
        System.out.println("战斗机正在向敌方方向移动 ...");
    }
}
