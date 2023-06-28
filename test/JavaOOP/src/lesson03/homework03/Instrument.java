package lesson03.homework03;

public class Instrument {
    private String name;

    public Instrument(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void play() {
        System.out.println(this.getName()+"在演奏");
    }
}
