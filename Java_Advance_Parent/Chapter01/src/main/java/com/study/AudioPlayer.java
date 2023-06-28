package com.study;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.AudioDevice;
import javazoom.jl.player.JavaSoundAudioDevice;
import javazoom.jl.player.Player;

import java.io.*;

/**
 * 音频播放类
 */
public class AudioPlayer {
    private static Player mPlayer = null;

    /**
     * 播放音频
     * @param musicPath 音频路径
     * @throws JavaLayerException
     */
    public static void play(String musicPath) throws JavaLayerException {
        try{
            BufferedInputStream buff = new BufferedInputStream(new FileInputStream(musicPath));
            mPlayer = new Player(buff);
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+"播放中" + musicPath);
                try {
                    synchronized(AudioPlayer.class){
                        System.out.println("进入线程同步，等待播放完当前这首歌才播放下一首");
                        mPlayer.play();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }).start();
            System.out.println("线程已启动");

        }catch(IOException io){
            io.printStackTrace();
        }
    }



    /**
     * 停止播放，关闭播放器
     */
    public static void stop() {
        if(mPlayer != null) {
            mPlayer.close();
        }
    }
}
