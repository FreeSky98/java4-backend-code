package lesson04.homework03;

public class PrinterTest {
    public static void main(String[] args) {
        Printer printer = new DotMatrixPrinter();
        printer.print();
        printer = new InkpetPrinter();
        printer.print();

        printer = new LaserPrinter();
        printer.print();
    }
}
