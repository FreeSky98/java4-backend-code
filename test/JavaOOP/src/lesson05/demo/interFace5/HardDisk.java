package lesson05.demo.interFace5;

public interface HardDisk {
    default String getCapacity() {
        return "1TB";
    }
}
