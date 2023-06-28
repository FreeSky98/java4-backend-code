import java.util.Scanner;

public class OOP_System {
    static final int ARRAY_LENGTH = 3; //定义数组大小
    static Scanner input = new Scanner(System.in);//键盘输入
    static String[] names = new String[ARRAY_LENGTH];//订单人姓名
    static String[] dishNames = {"红烧带鱼","鱼香肉丝","紫菜蛋汤"};//菜品名称
    static String[] dishMegs = new String[ARRAY_LENGTH];//菜品名称份数等信息
    static int[] times = new int[ARRAY_LENGTH];//送餐时间
    static String[] addresses = new String[ARRAY_LENGTH];//订单人地址
    static int[] states = new int[ARRAY_LENGTH];//订单状态
    static double[] prices = new double[] {38.0,20.0,10.0};//菜品单价
    static int[] praiseNums = new int[ARRAY_LENGTH];//点赞数
    static double[] sumPrices = new double[ARRAY_LENGTH];//订单总金额
    public static void startMenu() {
        System.out.println("欢迎使用“吃货联盟订餐系统”");
        System.out.println("*******************************************");
        System.out.println();
        System.out.println("1、我要订餐");
        System.out.println("2、查看餐袋");
        System.out.println("3、签收订单");
        System.out.println("4、删除订单");
        System.out.println("5、我要点赞");
        System.out.println("6、退出系统");
        System.out.println("*******************************************");
        System.out.println();
        System.out.print("请选择：");
    }//开始菜单
    public static void createOrder() {
        boolean isAdd = false; //检测是否可以订餐
        for (int i = 0; i < names.length; i++) {
            if (names[i] == null) { //找到空位置添加菜单信息
                isAdd = true; //表示可以开始订餐
                System.out.print("请输入订餐人姓名：");
                String name = input.next();

                System.out.println("序号\t"+"菜名\t\t\t"+"单价\t\t\t"+"点赞数\t");//菜品信息
                for (int j = 0; j < dishNames.length; j++) {
                    String price = prices[j] + "元"; //显示单价
                    String praiseNum = (praiseNums[j]) > 0 ? praiseNums[j] + "赞" : "0";//显示每个菜品的赞数
                    System.out.println((j + 1)+"\t"+dishNames[j]+"\t\t"+price+"\t\t"+praiseNum+"\t");
                }

                System.out.print("请选择您要点的菜品编号：");//点菜功能
                int chooseDish = input.nextInt();
                if (chooseDish < 1 || chooseDish > ARRAY_LENGTH) {
                    System.out.println("请输入正确的菜品编号！");
                    System.out.print("请选择您要点的菜品编号：");
                    chooseDish = input.nextInt();
                }
                System.out.print("请选择您需要的菜品份数：");
                int number = input.nextInt();
                String dishMeg = dishNames[chooseDish - 1] + " " + number + "份";
                double sumPrice = prices[chooseDish - 1] * number;
                double deliveryCharge = (sumPrice >= 50)? 0:6;//餐费满50免外送费，否则外送费6元

                System.out.print("请输入送餐时间（送餐时间是10点至20点间的整点送餐）：");//输入送餐时间
                int time = input.nextInt();
                while (time < 10 || time > 20) {
                    System.out.print("您输入的时间有误，请输入【10~20】之间的整数！");
                    time = input.nextInt();
                }
                System.out.print("请输入送餐地址：");
                String address = input.next();

                System.out.println("订餐成功！");//状态默认为0，代表已预订状态
                System.out.println("您预订的菜品：" + dishMeg);
                System.out.println("送餐时间：" + time + "点");
                System.out.println("餐费：" + sumPrice + "元，外送费"+deliveryCharge + "元，总计" + (sumPrice+deliveryCharge)+ "元。");

                //将用户输入的数据添加给数组
                names[i] = name;
                dishMegs[i] = dishMeg;
                times[i] = time;
                addresses[i] = address;
                sumPrices[i] = sumPrice;
            }
            if (!isAdd) {
                System.out.println("对不起，您的餐袋已满！");
            }
        }
    }//我要订餐功能
    public static void checkOrder() {
        /*String str = """
                订餐人      餐品信息      送餐日期      送餐地址       总金额      订单状态
                """;
            System.out.println(str);*/
        System.out.println("序号\t订餐人\t餐品信息\t\t送餐日期\t\t送餐地址\t总金额\t订单状态");


        for (int i = 0; i < names.length; i++) {
            if (names[i] != null) {
                /*str += """
                    %s      %s      %d      %s      %d       ¥%.2f      %s
                    """.formatted(
                        names[i],
                        dishMegs[i],
                        times[i],
                        addresses[i],
                        sumPrices[i],
                        (states[i] == 0)?"已预订":"已完成");
                System.out.println(str);*/

                String state = (states[i] == 0)?"已预订":"已完成";
                String date = times[i] + "点";
                String sumPrice = sumPrices[i] + "元";
                System.out.println((i+1)+"\t"+names[i]+"\t"
                        +dishMegs[i]+"\t\t"+date+"\t"
                        +addresses[i]+"\t\t"+sumPrice+"\t"+state);
            }
        }
    }//查看餐袋功能
    public static void signOrder() {
        boolean isSignOrder = false;//找到要签收的订单
        System.out.print("请选择要签收的订单序号：");
        int signOrderId = input.nextInt();
        if (signOrderId < 1 || signOrderId > ARRAY_LENGTH) {
            System.out.println("请输入正确的订单序号！");
            System.out.print("请选择您要点的订单序号：");
            signOrderId = input.nextInt();
        }
        for (int i = 0; i < names.length; i++) {
            if (names[i] != null && states[i] == 0 && signOrderId == i + 1) {
                states[i] = 1;//状态设置为已完成
                System.out.println("订单签收成功！");
                isSignOrder = true;
            } else if (names[i] != null && states[i] == 1 && signOrderId == i + 1) {
                System.out.println("您选择的订单已完成签收，不能再次签收！");
                isSignOrder = true;
            }
        }
        if (!isSignOrder) {
            System.out.println("您选择的订单不存在！");
        }
    }//签收订单功能
    public static void deleteOrder() {
        boolean isDelete = false; //检测是否可以删除
        System.out.print("请输入要删除的订单序号：");
        int deleteNum = input.nextInt();
        if (deleteNum < 1 || deleteNum > ARRAY_LENGTH) {
            System.out.println("请输入正确的订单序号！");
            System.out.print("请选择您要点的订单序号：");
            deleteNum = input.nextInt();
        }
        for (int i = 0; i < names.length; i++) {
            if (names[i]!= null && states[i] == 1 && deleteNum == i + 1) { //如果状态为已完成，订单序号加1是删除序号表示可删除
                isDelete = true;
                for (int j = deleteNum - 1; j < names.length - 1; j++) { //删除功能:删除位置后的元素前移
                    names[j] = names[j + 1];
                    dishMegs[j] = dishMegs[j + 1];
                    times[j] = times[j + 1];
                    addresses[j] = addresses[j + 1];
                    states[j] = states[j + 1];
                    sumPrices[j] = sumPrices[j + 1];
                }
                int endIndex = names.length - 1; //最后一位清空
                names[endIndex] = null;
                dishMegs[endIndex] = null;
                times[endIndex] = 0;
                addresses[endIndex] = null;
                states[endIndex] = 0;
                sumPrices[endIndex] = 0;
                System.out.println("删除订单成功！");
            } else if (names[i] != null && states[i] == 0 && deleteNum == i + 1) {
                System.out.println("您选择的订单未签收，无法删除！");
                isDelete = true;
            }
        }
        if (!isDelete) {
            System.out.println("您要删除的订单不存在！");
        }

    }//删除订单功能
    public static void praiseOrder() {
        System.out.println("序号\t菜名\t单价");
        for (int i = 0; i < dishNames.length; i++) {
            String price = prices[i] + "元";
            String praiseNum = praiseNums[i] > 0 ? praiseNums[i] + "赞" : "";
            System.out.println((i + 1) + "\t" + dishNames[i] + "\t" + price + "\t" + praiseNum);
        }
        System.out.print("请输入您想要点赞的菜品序号：");
        int praiseNum = input.nextInt();
        if (praiseNum < 1 || praiseNum > ARRAY_LENGTH) {
            System.out.println("请输入正确的菜品序号！");
            System.out.print("请输入您想要点赞的菜品序号：");
            praiseNum = input.nextInt();
        }
        praiseNums[praiseNum - 1]++; //菜品的点赞数自加1
        System.out.println("点赞成功！");
    }//我要点赞功能

    public static void main(String[] args) {
        int num;//定义选择号码
        do {
            startMenu();//显示菜单
            int choose = input.nextInt();
            switch (choose) { //跳转功能
                case 1 -> {
                    System.out.println("***我要订餐***");
                    createOrder();
                }
                case 2 -> {
                    System.out.println("***查看餐袋***");
                    checkOrder();
                }
                case 3 -> {
                    System.out.println("***签收订单***");
                    signOrder();
                }
                case 4 -> {
                    System.out.println("***删除订单***");
                    deleteOrder();
                }
                case 5 -> {
                    System.out.println("***我要点赞***");
                    praiseOrder();
                }
                case 6 -> {
                    System.out.println("***谢谢使用，欢迎下次光临***");
                    System.exit(0);
                }
                default -> System.out.println("输入的菜单序号有误，请重试！");
            }
            //返回功能
            System.out.print("输入0返回：");
            num = input.nextInt();
            if (num != 0) {
                System.out.println("请输入0返回，继续输入其他数字则会退出系统！");
                System.out.print("输入0返回：");
                num = input.nextInt();
            }
        } while (num == 0);
    }
}
