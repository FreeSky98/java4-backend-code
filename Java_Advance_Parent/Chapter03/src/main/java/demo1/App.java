package demo1;

import javax.swing.filechooser.FileSystemView;
import java.io.File;
import java.text.NumberFormat;

public class App {

    public static void main(String[] args) {
        //listRoots()静态方法，返回计算机上所有驱动器
        File[] driveList = File.listRoots();
        FileSystemView fileSystemView = FileSystemView.getFileSystemView();
        System.out.println("名称\t\t\t\t\t类型\t\t\t\t总大小\t\t可用空间");

        for (File drive : driveList) {
            String name = fileSystemView.getSystemDisplayName(drive);
            String description = fileSystemView.getSystemTypeDescription(drive);
            long totalSpace = drive.getTotalSpace();//获取总磁盘大小(Bytes)
            long freeSpace = drive.getFreeSpace();
            System.out.println(name+"\t\t"+description+"\t\t"+toGB(totalSpace)+"Gb"+"\t\t"+toGB(freeSpace)+"Gb");
        }
    }

    /**
     * 保留小数位
     * @param val
     * @return String
     */
    public static String toDecimal(double val,int fraction) {
        NumberFormat df = NumberFormat.getInstance();
        df.setMaximumFractionDigits(fraction);
        return df.format(val);
    }

    public static String toGB(long size) {
        return toDecimal(size * 1.0 / 1024 / 1024 / 1024,2);
    }
}
