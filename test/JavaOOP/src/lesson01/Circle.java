package lesson01;

import java.util.Scanner;

public class Circle {
    int radius;
    double area;
    double perimeter;

    public void getArea() {
        this.area = this.radius * this.radius * 3.14159265354;
        System.out.println("该圆的面积是：" + area);
    }

    public void getPerimeter() {
        this.perimeter =2 * 3.14159265354 * this.radius;
        System.out.println("该圆的周长是：" + perimeter);
    }
}

class circleTest {
    public static void main(String[] args) {
        Circle circle = new Circle();
        Scanner input = new Scanner(System.in);
        System.out.print("请输入圆的半径：");
        circle.radius = input.nextInt();
        circle.getArea();
        circle.getPerimeter();
    }
}
