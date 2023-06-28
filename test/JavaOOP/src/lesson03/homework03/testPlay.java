package lesson03.homework03;

public class testPlay {
    public static void main(String[] args) {
        Piano piano = new Piano("雅马哈钢琴");
        Violin violin = new Violin("红棉小提琴");
        piano.play();
        violin.play();
    }
}
