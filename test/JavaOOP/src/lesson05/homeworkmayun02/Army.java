package lesson05.homeworkmayun02;

public class Army {
    //写一个类Army,代表一支军队，这个类有一个属性是Weapon数组weapons（用来存储该军队所拥有的所有武器）
    //该类还提供一个构造方法，在构造方法里通过传一个int类型的参数来限定该类所能拥有的最大武器数量,并用这一大小来初始化数组w。
    //该类还提供一个方法addWeapon(Weapon weapon),表示把参数weapon所代表的武器加入到数组weapons中。
    //在这个类中还定义两个方法attackAll()和moveAll()，让weapons数组中的所有武器攻击和移动
    private Weapon[] weapons;

    public Army(int weaponsNumber) {
        this.weapons = new Weapon[weaponsNumber];
    }

    public Weapon[] getWeapons() {
        return weapons;
    }

    public void setWeapons(Weapon[] weapons) {
        this.weapons = weapons;
    }

    public void addWeapon(Weapon weapon) {
        for (int i = 0; i < weapons.length; i++) {
            if (weapons[i] == null) {
                weapons[i] = weapon;
                System.out.println("武器库已增加"+(i+1)+"个武器");
                break;
            }
        }
    }

    public void attackAll() {
        System.out.println("所有武器准备战斗！！！");
        int count = 0;
        for (Weapon weapon : weapons) {
            count++;
            System.out.print(count + "号");
            weapon.attack();
        }
    }

    public void moveAll() {
        System.out.println("所有武器准备移动！！！");
        int count = 0;
        for (Weapon weapon : weapons) {
            count++;
            System.out.print(count + "号");
            weapon.move();
        }
    }
}
