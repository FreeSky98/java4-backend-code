import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class Method {
    static Scanner input = new Scanner(System.in);
    static Vip vip = new Vip();
    static List<Vip> vipList = new ArrayList<>();
    public static void showInfo() {
        System.out.println("******************欢迎进入超市会员管理系统****************************");
        System.out.println("1.积分累计\t2.积分兑换\t3.查询剩余积分\t4.修改密码\t5.开卡\t6.退出\t");
        System.out.println("******************************************************************");
        System.out.print("请选择：");
    }
    public static void choose() {
        do {
            showInfo();
            int choose = input.nextInt();
            switch (choose) {
                case 1 -> addPoint();
                case 2 -> exchangePoint();
                case 3 -> searchPoint();
                case 4 -> changePassword();
                case 5 -> register();
                case 6 -> exit();
            }
        } while (true);
    }

    public static void register() {
        System.out.print("请输入注册姓名：");
        String username = input.next();
        vip.setUsername(username);//存储用户名

        System.out.print("请输入注册密码：");
        String password = input.next();
        while (password.length() < 6) {
            System.out.println("密码长度不能小于6位！");
            System.out.print("请再次输入注册密码：");
            password = input.next();
        }
        vip.setPassword(password);//存储密码

        Random random = new Random();
        Integer cardNo = random.nextInt(110000000) + 10000000;
        vip.setCardNo(cardNo);

        vip.setPoint(100);//存储开卡积分

        Date date = new Date();
        String format = "yyyy-MM-dd";
        DateFormat df = new SimpleDateFormat(format);//创建日期格式化对象
        String formatted = df.format(date);//格式化后日期字符串
        vip.setOpenDate(formatted);//存储开卡日期

        vipList.add(vip);//将vip对象传入集合
        System.out.println("恭喜，开通会员卡成功，系统赠送您100积分！您的会员卡号为：" + cardNo);
    }

    public static void addPoint() {

    }

    public static void exchangePoint() {

    }

    public static void searchPoint() {
        if (isLogin()) {
            System.out.println(vip.getUsername() + "\t" + vip.getCardNo() + "\t" + vip.getPoint() + "\t" + vip.getOpenDate());
        }
    }

    public static void changePassword() {

    }

    public static void exit() {
        System.out.println("感谢您的使用，欢迎下次使用！");
        System.exit(0);
    }

    public static boolean isLogin() {
        System.out.print("请输入您的会员卡号：");
        int inputCardNo = input.nextInt();
        System.out.print("请输入您的会员卡密码：");
        String inputPassword = input.next();
        return Objects.equals(inputPassword, vip.getPassword()) && Objects.equals(inputCardNo, vip.getCardNo());
    }
}
