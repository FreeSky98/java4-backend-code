package lesson05.demo.interFace5;

public interface CPU {
    /**
     * CPU品牌信息
     *
     * @return CPU品牌信息
     */
    default String getBrand() {
        return "Intel";
    }

    /**
     * 主频信息
     * @return 主频信息
     */
    default String getFrequency() {
        return "3.8GHz";
    }
}
