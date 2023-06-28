package lesson05.demo.interFace5;

public class Computer {
    private CPU cpu;
    private HardDisk hd;
    private EMS ems;

    public void info() {
        System.out.println("计算机信息如下：");
        System.out.println("CPU品牌："+this.cpu.getBrand()+",主频："+this.cpu.getFrequency());
        System.out.println("硬盘容量是："+this.hd.getCapacity());
        System.out.println("内存大小是："+this.ems.getCapacity());
    }

    public Computer(CPU cpu, HardDisk hd, EMS ems) {
        this.cpu = cpu;
        this.hd = hd;
        this.ems = ems;
    }

    public CPU getCpu() {
        return cpu;
    }

    public void setCpu(CPU cpu) {
        this.cpu = cpu;
    }

    public HardDisk getHd() {
        return hd;
    }

    public void setHd(HardDisk hd) {
        this.hd = hd;
    }

    public EMS getEms() {
        return ems;
    }

    public void setEms(EMS ems) {
        this.ems = ems;
    }
}
