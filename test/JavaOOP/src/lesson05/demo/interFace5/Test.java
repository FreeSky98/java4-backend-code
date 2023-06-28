package lesson05.demo.interFace5;

public class Test {
    public static void main(String[] args) {
        Computer computer = new Computer(new Intel(), new HP(),new Kingston(){
        });
        computer.info();
    }
}
