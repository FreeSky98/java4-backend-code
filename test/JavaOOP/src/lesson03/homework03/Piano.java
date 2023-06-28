package lesson03.homework03;

public class Piano extends Instrument{
    public Piano(String name) {
        super(name);
    }
    public void play() {
        System.out.println(this.getName()+"在演奏,弹奏出悠扬的琴声~");
    }
}
