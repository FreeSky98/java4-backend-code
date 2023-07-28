import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class Method {
    static Scanner input = new Scanner(System.in);
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

        System.out.print("请输入注册密码：");
        String password = input.next();
        while (password.length() < 6) {
            System.out.println("密码长度不能小于6位！");
            System.out.print("请再次输入注册密码：");
            password = input.next();
        }

        Random random = new Random();
        Integer cardNo = random.nextInt(110000000) + 10000000;

        Date date = new Date();
        String format = "yyyy-MM-dd";
        DateFormat df = new SimpleDateFormat(format);//创建日期格式化对象
        String formatted = df.format(date);//格式化后日期字符串

        vipList.add(new Vip(username, cardNo, password, 100, formatted));//将vip对象传入集合
        System.out.println("恭喜，开通会员卡成功，系统赠送您100积分！您的会员卡号为：" + cardNo);
    }

    public static void addPoint() {
        for (Vip vip : vipList) {
            if (isLogin()) {
                System.out.print("请输入您此次消费的金额(消费1元累计1积分):");
                BigDecimal money = new BigDecimal(input.next());
//            System.out.println(money);
                int res = vip.getPoint() + money.intValue();
                vip.setPoint(res);
                System.out.println("积分累计成功！");
                break;
            }
        }
    }

    public static void exchangePoint() {
        for (Vip vip : vipList) {
            if (isLogin()) {
                System.out.println("请输入您需要兑换使用的积分(100积分抵用0.1元,不足100的积分不能抵用):");
                int inputPoint = input.nextInt();

                if (vip.getPoint() < 100 || vip.getPoint() < inputPoint) {
                    System.err.println("抱歉，您的积分不足，无法兑换！");
                } else {
                    double exchangedMoney = (double) inputPoint / 1000;
                    int res = vip.getPoint() - inputPoint;
                    vip.setPoint(res);
                    System.out.println("您的消费金额中使用会员积分抵消" + exchangedMoney + "元");
                    System.out.println("积分兑换成功！");
                    break;
                }
            }
        }
    }


    public static void searchPoint() {
        for (Vip vip : vipList) {
            if (isLogin()) {
                System.out.println("姓名\t\t会员卡号\t\t\t积分\t\t开卡日期");
                System.out.println(vip.getUsername() + "\t\t" + vip.getCardNo() + "\t\t" + vip.getPoint() + "\t\t" + vip.getOpenDate());
                break;
            }
        }
    }

    public static void changePassword() {
        for (Vip vip : vipList) {
            if (isLogin()) {
                System.out.print("请输入新的会员密码：");
                String password = input.next();
                while (password.length() < 6) {
                    System.out.println("密码长度不能小于6位！");
                    System.out.print("请再次输入注册密码：");
                    password = input.next();
                }
                while (password.equals(vip.getPassword())) {
                    System.err.println("新密码和上次密码不能相同！");
                    System.out.print("请再次输入注册密码：");
                    password = input.next();
                }
                vip.setPassword(password);//存储密码
                System.out.println("密码修改成功！");
                break;
            }
        }
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
        for (Vip vip : vipList) {
            if (vip.getPassword().equals(inputPassword) && vip.getCardNo().equals(inputCardNo)) {
                return true;
            } else {
                System.err.println("会员卡号或密码输入有误！请重试...");
                return false;
            }
        }
        return false;
    }
}
