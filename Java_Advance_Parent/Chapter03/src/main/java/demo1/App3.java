package demo1;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.text.SimpleDateFormat;
import java.util.Date;

public class App3 {
    public static void main(String[] args) throws IOException {
        //使用java.util.File操作文件
        File fileObj = new File("C:\\Users\\朝日日语王先生\\Desktop\\日语练习题合集\\高考日语题库\\福建2022高考日语质检\\8.jpg");
        MyFile myFile = new MyFile();
        // 文件对象.getName()方法获取指定的文件名称
        String fileName = fileObj.getName();
        myFile.setFileName(fileName);
        myFile.setFileExtension(fileName.substring(fileName.lastIndexOf('.')));
        myFile.setFilePath(fileObj.getAbsolutePath());
        myFile.setHidden(fileObj.isHidden());
        myFile.setReadOnly(!fileObj.canWrite());
        myFile.setFileSize(fileObj.length());

        //////////////////////获取文件的创建时间/////////////////////
        // 根据文件的绝对路径获取Path
        Path path = Paths.get(fileObj.getAbsolutePath());
        // 根据path获取文件的基本属性类
        BasicFileAttributes attrs = Files.readAttributes(path, BasicFileAttributes.class);
        // 从基本属性类中获取文件创建时间
        FileTime fileTime = attrs.creationTime();
        // 将文件创建时间转成毫秒
        long millis = fileTime.toMillis();
        SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
        Date createdAt  = new Date();
        createdAt.setTime(millis);
        myFile.setCreatedAt(createdAt);


        System.out.println("文件名称是：" + myFile.getFileName());
        System.out.println("文件类型是：" + myFile.getFileExtension());
        System.out.println("文件绝对路径是：" + myFile.getFilePath());
        System.out.println("文件创建时间是：" + dateFormat.format(myFile.getCreatedAt()));
        System.out.println("文件大小是（字节为单位）：" + myFile.getFileSize());
        System.out.println("文件是否为只读：" + myFile.isReadOnly());
        System.out.println("文件是否为隐藏：" + myFile.isHidden());
    }
}
class MyFile {
    private String fileName;
    private String fileExtension;
    private long fileSize;
    private String filePath;
    private Date createdAt;
    private boolean readOnly;
    private boolean hidden;



    public MyFile() {
    }

    public MyFile(String fileName, String fileExtension, long fileSize, String filePath, Date createdAt, boolean readOnly, boolean hidden) {
        this.fileName = fileName;
        this.fileExtension = fileExtension;
        this.fileSize = fileSize;
        this.filePath = filePath;
        this.createdAt = createdAt;
        this.readOnly = readOnly;
        this.hidden = hidden;
    }

    public boolean isReadOnly() {
        return readOnly;
    }

    public void setReadOnly(boolean readOnly) {
        this.readOnly = readOnly;
    }

    public boolean isHidden() {
        return hidden;
    }

    public void setHidden(boolean hidden) {
        this.hidden = hidden;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileExtension() {
        return fileExtension;
    }

    public void setFileExtension(String fileExtension) {
        this.fileExtension = fileExtension;
    }

    public long getFileSize() {
        return fileSize;
    }

    public void setFileSize(long fileSize) {
        this.fileSize = fileSize;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}