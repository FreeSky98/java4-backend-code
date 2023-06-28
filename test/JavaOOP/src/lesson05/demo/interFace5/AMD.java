package lesson05.demo.interFace5;

public class AMD implements CPU{
    @Override
    public String getBrand() {
        //return CPU.super.getBrand();
        return "AMD";
    }

    @Override
    public String getFrequency() {
        //return CPU.super.getFrequency();
        return "3.7GHz";
    }
}
