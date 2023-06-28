package lesson03.homework03;

public class Violin extends Instrument{
    public Violin(String name) {
        super(name);
    }
    public void play() {
        System.out.println(this.getName()+"在演奏,拉出动听的琴声~");
    }
}
