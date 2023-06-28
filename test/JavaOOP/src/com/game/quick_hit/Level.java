package com.game.quick_hit;

public class Level {
    /**
     * 各级别号（levelNo）
     * 各级别一次输出字符串的长度（strLength）
     * 各级别输出字符串的次数（strTimes）
     * 各级别闯关的时间限制（timeLimit）
     * 各级别正确输入一次的得分（perScore）
     */
    private int levelNo;
    private int strLength;
    private int strTimes;
    private int timeLimit;
    private int perScore;

    public Level() {
    }

    public Level(int levelNo, int strLength, int strTimes, int timeLimit, int perScore) {
        this.levelNo = levelNo;
        this.strLength = strLength;
        this.strTimes = strTimes;
        this.timeLimit = timeLimit;
        this.perScore = perScore;
    }

    public int getLevelNo() {
        return levelNo;
    }

    public int getStrLength() {
        return strLength;
    }

    public int getStrTimes() {
        return strTimes;
    }

    public int getTimeLimit() {
        return timeLimit;
    }

    public int getPerScore() {
        return perScore;
    }
}
