package lesson03.demo.depend;

public class Person {
    //人实体依赖车实体  - 依赖关系

    /**
     * 旅游
     * @param car 汽车对象
     */
    public void travel(Car car) {
        car.run("北京");
    }

}
