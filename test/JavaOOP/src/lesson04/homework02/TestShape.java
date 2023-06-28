package lesson04.homework02;

/**
 * 接口Shape
 */
interface Shape {
    double getPerimeter();//周长
    double getArea();//面积
}
/**
 * 圆形类
 * */
class Circle implements Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    public double getArea() {
        return Math.PI * radius * radius;
    }
}
/**
 * 平行四边形
 * */
class Parallelogram implements Shape {
    private double base;//底
    private double height;//高
    private double side;//边

    public Parallelogram(double base, double height, double side) {
        this.base = base;
        this.height = height;
        this.side = side;
    }

    public double getPerimeter() {
        return 2 * (base + side);
    }

    public double getArea() {
        return base * height;
    }
}
/**
 * 长方形
 * */
class Rectangle extends Parallelogram {
    public Rectangle(double width, double height) {
        super(width, height, width);
    }
}
/**
 * 梯形
 * */
class Trapezoid implements Shape {
    private double base1;//底1
    private double base2;//底2
    private double height;//高
    private double side1;//边1
    private double side2;//边2

    public Trapezoid(double base1, double base2, double height, double side1, double side2) {
        this.base1 = base1;
        this.base2 = base2;
        this.height = height;
        this.side1 = side1;
        this.side2 = side2;
    }

    public double getPerimeter() {
        return base1 + base2 + side1 + side2;
    }

    public double getArea() {
        return (base1 + base2) * height / 2;
    }
}

public class TestShape {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[4];
        shapes[0] = new Circle(5);//圆形
        shapes[1] = new Rectangle(3, 4);//长方形
        shapes[2] = new Parallelogram(5, 6, 7);//平行四边形
        shapes[3] = new Trapezoid(3, 5, 4, 6, 8);//梯形

        System.out.println("圆形周长:" + shapes[0].getPerimeter());
        System.out.println("圆形面积: " + shapes[0].getArea());
        System.out.println();

        System.out.println("长方形周长:" + shapes[1].getPerimeter());
        System.out.println("长方形面积: " + shapes[1].getArea());
        System.out.println();

        System.out.println("平行四边形周长:" + shapes[2].getPerimeter());
        System.out.println("平行四边形面积: " + shapes[2].getArea());
        System.out.println();

        System.out.println("梯形周长:" + shapes[3].getPerimeter());
        System.out.println("梯形面积: " + shapes[3].getArea());
        System.out.println();

    }
}
