package lesson05.homeworkmayun01;

public class PillarTest {
    public static void main(String[] args) {
        Circle circle = new Circle(5);
        Pillar p1 = new Pillar(circle.getArea(),20);
        System.out.println("半径为"+circle.getRadius()+"的圆柱体的面积是：" + p1.getVolume());

        Rectangle rectangle = new Rectangle(3,5);
        Pillar p2 = new Pillar(rectangle.getArea(), 20);
        System.out.println("矩形长为"+rectangle.getLength()+
                ",宽为"+rectangle.getWidth()+
                ",高为"+p2.getHeight()+
                "的矩形柱体的面积是：" + p2.getVolume());
    }
}
