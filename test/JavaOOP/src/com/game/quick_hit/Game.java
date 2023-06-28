package com.game.quick_hit;

import java.util.Random;

public class Game {
    private Player player;

    public Game(Player player) {
        this.player = player;
    }
    public Game() {}

    public String printStr() {
        int strLength = LevelParam.levels[player.getLevelNo() - 1].getStrLength();
        StringBuffer buffer = new StringBuffer();
        Random random = new Random();
        for (int i = 0; i < strLength; i++) {
            int rand = random.nextInt(strLength);
            // 根据随机数拼接字符串
            switch (rand) {
                case 0 -> buffer.append(">");
                case 1 -> buffer.append("<");
                case 2 -> buffer.append("*");
                case 3 -> buffer.append("&");
                case 4 -> buffer.append("%");
                case 5 -> buffer.append("#");
            }
        }
        System.out.println(buffer);
        return buffer.toString();
    }
    /**
     * 判断玩家输入是否正确，并输出相应结果信息。
     * @param out 游戏输出的字符串
     * @param in 玩家输入的字符串
     */
    public void printResult(String out,String in) {
        boolean flag;
        flag = out.equals(in);
        // 1、 如果输入正确
        if (flag) {
            long currentTime = System.currentTimeMillis();
            // 1.1、 如果超时
            if ((currentTime - player.getStartTime()) / 1000
                    >LevelParam.levels[player.getLevelNo() - 1].getTimeLimit()) {
                System.out.println("你输入太慢了，已经超时，退出！");
                System.exit(1);
                // 1.2、 如果没有超时
            } else {
                // 1.2.1、 计算当前积分
                player.setCurrScore(player.getCurrScore()
                        + LevelParam.levels[player.getLevelNo() - 1].getPerScore());
                // 1.2.2、 计算已用时间
                player.setElapsedTime((int) ((currentTime - player
                        .getStartTime()) / 1000));
                // 1.2.3、输出当前积分、当前级别、已用时间
                System.out.println("输入正确，您的级别"+ player.getLevelNo()+" ,您的积分" + player.getCurrScore() + ",已用时间"	+ player.getElapsedTime() + "秒。");
                // 1.2.4、判断用户是否已经闯过最后一关
                if (player.getLevelNo() == 6) {
                    int score=LevelParam.levels[player.getLevelNo() - 1].getPerScore()
                            * LevelParam.levels[player.getLevelNo() - 1].getStrTimes();//计算闯关分数
                    if (player.getCurrScore() == score) {
                        System.out.println("闯关成功，打字速度无人能及，恭喜您！！！");
                        System.exit(0);
                    }
                }
            }
            // 2、如果输入错误
        } else {
            System.out.println("输入错误，退出！");
            System.exit(1);
        }
    }
}
