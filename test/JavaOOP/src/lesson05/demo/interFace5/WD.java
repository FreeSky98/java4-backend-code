package lesson05.demo.interFace5;

public class WD implements HardDisk{
    @Override
    public String getCapacity() {
        //return HardDisk.super.getCapacity();
        return "512GB";
    }
}
