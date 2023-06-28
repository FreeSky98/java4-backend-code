package lesson05.homework03;

public class Test {
    public static void main(String[] args) {
        PCI[] pcis = new PCI[] {new VideoCard(),new AudioCard(),new NetCard()};
        for (PCI pci : pcis) {
            pci.send();
        }
    }
}
