package com.game.quick_hit;

import java.util.Scanner;

public class Player {
    /**
     * 玩家当前级别号（levelNo）
     * 玩家当前级别积分（currScore）
     * 当前级别开始时间（startTime）
     * 当前级别已用时间（elapsedTime）
     */
    private int levelNo;
    private int currScore;
    private long startTime;
    private int elapsedTime;
    public void play() {
        Game game = new Game(this);
        Scanner input = new Scanner(System.in);
        // 外层循环，循环一次级别晋一级
        for (int i = 0; i < LevelParam.levels.length; i++) {
            this.levelNo += 1;
            this.startTime = System.currentTimeMillis();
            this.currScore = 0;
            // 3、 内层循环，循环一次完成一次字符串的输出、输入、比较
            for (int j = 0; j < LevelParam.levels[levelNo-1].getStrTimes(); j++) {
                String outStr = game.printStr();
                String inStr = input.next();
                game.printResult(outStr, inStr);
            }
        }
    }

    public int getLevelNo() {
        return levelNo;
    }

    public void setLevelNo(int levelNo) {
        this.levelNo = levelNo;
    }

    public int getCurrScore() {
        return currScore;
    }

    public void setCurrScore(int currScore) {
        this.currScore = currScore;
    }

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public int getElapsedTime() {
        return elapsedTime;
    }

    public void setElapsedTime(int elapsedTime) {
        this.elapsedTime = elapsedTime;
    }
}
