package com.study;

import java.util.Objects;

/**
 * 歌曲类
 * @author lds
 */
public class Song {
    /**
     * 歌曲名称
     */
    private String songName;

    /**
     * 歌曲播放地址
     */
    private String playUrl;

    public Song() {
    }

    public Song(String songName) {
        this.songName = songName;
    }

    public Song(String songName, String playUrl) {
        this.songName = songName;
        this.playUrl = playUrl;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getPlayUrl() {
        return playUrl;
    }

    public void setPlayUrl(String playUrl) {
        this.playUrl = playUrl;
    }

    @Override
    public boolean equals(Object obj) {
        // 判断对象是否为null
        if(obj == null) return false;
        // 判断对象类型是否是Song类型
        if(!(obj instanceof Song)) return false;
        // 将obj强制类型转化为Song类型对象
        Song song = (Song) obj;
        // 判断当前对象的歌曲名和另一个对象歌曲名是否相等，如果不相等返回false
        if(!this.songName.equals(song.songName)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        // 计算当前对象歌曲名songName的哈希码值(内存地址值)
        return Objects.hash(this.songName);
    }

    @Override
    public String toString() {
        return "歌曲信息：歌曲名：" + this.getSongName() + "，歌曲播放路径:"  + this.getPlayUrl();
    }
}
