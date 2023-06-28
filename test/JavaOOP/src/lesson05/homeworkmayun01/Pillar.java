package lesson05.homeworkmayun01;

public class Pillar {
    private double bottom;
    private int height;

    public Pillar(double bottom, int height) {
        this.bottom = bottom;
        this.height = height;
    }

    public double getBottom() {
        return bottom;
    }

    public void setBottom(double bottom) {
        this.bottom = bottom;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
    public double getVolume() {
        return this.bottom * this.height;
    }
}
