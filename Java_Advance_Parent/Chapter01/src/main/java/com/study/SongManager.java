package com.study;

import java.io.File;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class SongManager {
    //歌曲列表
    private final static List<Song> songList = new ArrayList<>();
    // 获取音频文件存储的路径
    private static String filePath = SongManager.class.getClassLoader().getResource("music").getPath();

    static {
        // 默认歌曲
        songList.add(new Song("十年", filePath + "/十年.mp3"));
        songList.add(new Song("吻别", filePath + "/吻别.mp3"));
        songList.add(new Song("晴天", filePath + "/晴天.mp3"));
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        do {
            System.out.println("------------------------------");
            System.out.println("\t1、新增歌曲");
            System.out.println("\t2、查询歌曲");
            System.out.println("\t3、修改歌曲");
            System.out.println("\t4、删除歌曲");
            System.out.println("\t5、播放歌曲");
            System.out.println("\t6、退出系统");
            System.out.println("-------------------------------");
            System.out.print("请选择：");
            try {
                int choose = input.nextInt();
                switch (choose) {
                    case 1 -> {
                        System.out.println("请输入歌曲名:");
                        String songName = input.next();
                        System.out.println("请输入歌曲完整路径:");
                        String songPath = input.next();
                        Song newSong = new Song(songName, songPath);
                        if (songList.contains(newSong)) {
                            throw new RuntimeException("歌曲重复，请重试！");
                        }
                        File songFile = new File(songPath);
                        if (!songFile.exists()) {
                            throw new RuntimeException("歌曲播放路径不存在，请重试！");
                        }
                        // 将新歌曲对象添加到数组列表中
                        songList.add(newSong);
                    }
                    case 2 -> {
                        System.out.print("请输入歌曲名(支持模糊查询):");
                        String songName = input.next();
                        // 判断ArrayList集合是否是空集合，如果是空集合返回true
                        if (songList.isEmpty() || songList.size() == 0) {
                            throw new RuntimeException("暂无歌曲！");
                        } else {
                            System.out.println("序号\t\t歌曲名\t\t播放路径");
                            AtomicInteger k = new AtomicInteger();
                            // 第一种方法普通for循环遍历ArrayList集合
                         /*for (int i = 0; i < songList.size(); i++) {
                             Song song = songList.get(i);
                             if(song.getSongName().indexOf(songName) >= 0) {
                                 System.out.println((i+1)+ "\t\t" + song.getSongName() + "\t\t\t" + song.getPlayUrl());
                             }
                         }*/
                            //System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
                            // 第二种方法增强for循环遍历ArrayList集合
                         /*
                         for (Song song : songList) {
                             if(song.getSongName().indexOf(songName) >= 0) {
                                 System.out.println((++k)+ "\t\t" + song.getSongName() + "\t\t\t" + song.getPlayUrl());
                             }
                         }*/
                            System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
                            // 第三种方法使用迭代器遍历ArrayList集合
                            Iterator<Song> it = songList.iterator();
                         /*
                            迭代器是用来遍历容器内所有元素对象的，也是一种常见的设计模式。
                           1.hasNext()方法用于判断集合中是否还有下一个元素。如果有，返回true，否则返回false。
                           2.next()方法用于取出集合中的下一个元素。在遍历集合的过程中，我们可以不断地调用next()方法取出下一个元素，直到hasNext()方法返回false。
                           3.remove()方法用于删除集合中的当前元素。在遍历集合的过程中，如果我们需要删除集合中的某个元素，可以直接调用remove()方法。
                          */
                         /*k = 0;
                         while (it.hasNext()) {
                             Song song = it.next();
                             if(song.getSongName().indexOf(songName) >= 0) {
                                 System.out.println((++k)+ "\t\t" + song.getSongName() + "\t\t\t" + song.getPlayUrl());
                             }
                         }*/

                            //第四种方法循环遍历集合
                            songList.forEach(song -> {
                                if (song.getSongName().indexOf(songName) >= 0) {
                                    int index = 0;
                                    System.out.println((++index) + "\t\t" + song.getSongName() + "\t\t\t" + song.getPlayUrl());
                                }
                            });
                        }
                    }
                    case 3 -> {
                        System.out.print("请输入原歌曲名:");
                        String oldSongName = input.next();

                        // 使用Stream按条件查询指定歌曲对象
                    /*Song oldSong = songList
                            .stream()
                            .filter(song -> song.getSongName().equals(songName))
                            .findFirst()
                            .orElseThrow(() -> new RuntimeException("没有查询到此歌曲！"));*/
                        //System.out.println(oldSong.toString());

                        int index = -1;
                        Song newSong = new Song();
                    /*
                    int size()	返回列表中的元素个数
                    Song get(int index)	返回指定索引位置处的元素。
                     */
                        for (int i = 0; i < songList.size(); i++) {
                            Song song = songList.get(i);
                            if (song.getSongName().equals(oldSongName)) {
                                index = i;
                                break;
                            }
                        }

                        if (index == -1) {
                            throw new RuntimeException("没有查询到此歌曲！");
                        } else {
                            System.out.print("请输入新歌曲名称：");
                            String newSongName = input.next();
                            System.out.print("请输入新歌曲播放路径：");
                            String newPlayUrl = input.next();
                            if (songList.contains(newSongName)) {
                                throw new RuntimeException("歌曲重复，请重试！");
                            }
                            File songFile = new File(newPlayUrl);
                            if (!songFile.exists()) {
                                throw new RuntimeException("歌曲播放路径不存在，请重试！");
                            }
                            newSong.setSongName(newSongName);
                            newSong.setPlayUrl(newPlayUrl);
                            songList.set(index, newSong);
                            System.out.println("修改歌曲信息成功！");
                        }
                    }
                    case 4-> {
                        System.out.print("请输入想要删除歌曲名:");
                        String songName = input.next();
                        /*
                        ListIterator 接口则在继承 Iterator 接口的基础上定义了：add(E newElement)、set(E newElement)、hasPrevious()、previous()、nextIndex()、previousIndex() 等方法，使得 ListIterator 迭代能力增强，能够进行双向迭代、迭代过程中可以进行增删改操作。
                        1.void add(E e) 将指定的元素插入列表中。
                        2.boolean hasNext() 如果此列表迭代器在向前遍历列表时具有元素，则返回true。
                        3.boolean hasPrevious() 如果此列表迭代器在反向遍历列表时具有元素，则返回true。
                        4.E next() 返回列表中的下一个元素。
                        5.int nextIndex() 返回元素的索引。
                        6.E previous() 返回列表中的上一个元素并向后移动光标位置。
                        7.int previousIndex() 返回元素的索引。
                        8.void remove() 从列表中删除由next()或previous()返回的最后一个元素。
                        9.void set(E e) 用指定的元素替换由next()或previous()返回的最后一个元素。
                         */
                        ListIterator<Song> listIt = songList.listIterator();
                        Song songItem = null;
                        while (listIt.hasNext()) {
                            Song song = listIt.next();
                            if(song.getSongName().equals(songName)) {
                                //listIt.remove();
                                //System.out.println("删除歌曲成功！");
                                songItem = song;
                                break;
                            }
                        }
                        if(songItem != null) {
                            //songList.remove(0); // 根据指定索引位置删除元素
                            songList.clear(); // 清空集合
                            //songList.removeIf()
                            //songList.remove(songItem);
                            System.out.println("删除歌曲成功！");
                        } else {
                            System.out.println("没有找到要删除歌曲！");
                        }
                    }
                    case 5 -> {
                        System.out.print("请输入歌曲名：");
                        String songName = input.next();
                        if (songList.contains(new Song(songName))) {
                            Optional<Song> songOptional = songList.stream().filter(song -> song.getSongName().equalsIgnoreCase(songName)).findFirst();
                            Song song = songOptional.get();
                            String videoPath = song.getPlayUrl();
                            AudioPlayer audioPlayer = new AudioPlayer();
                            audioPlayer.play(videoPath);
                            System.out.println("播放成功！正在播放中~");
                        }
                        else {
                           throw new RuntimeException("播放失败：未找到歌曲!");
                        }
                    }
                    case 6 -> System.exit(0);
                }
            } catch (Exception ex) {
                System.out.println("错误消息是：" + ex.getMessage());
            }
        } while (true);

    }

}
