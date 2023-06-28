package lesson05.demo.interFace5;

public interface EMS {

    default String getType() {
        return "金士顿";
    }
    default String getCapacity() {
        return "1TB";
    }
}
