package org.net1;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 文件存储服务器
 * @author daniu
 */
public class FileStorageServer {
    // 定义文件存储服务器---分配的端口号
    private static final int SERVER_PORT = 8888;
    //服务器保存文件目录路径,如果此目录不存在，通过Java代码动态创建它
    private static final String UPLOAD_SAVE_PATH = "D:/uploads";

    /**
     * 主服务
     * @param args
     */
    public static void main(String[] args) {
        ServerSocket fileServer = null;
        try{
            // 创建文件存储服务器对象(fileServer)
            fileServer = new ServerSocket(SERVER_PORT);
            System.out.println("文件存储服务器已成功启动 ...");
            for(;;) { // 服务器一直运行，提供客户端服务，因此我这里使用死循环
                //accept()方法，接收客户端连接请求，注意：此方法是一个阻塞方法，一直等待客户端连接请求。
                final Socket s = fileServer.accept(); // Socket s表示某个一新的客户端对象
                // 获取远程客户端IP地址   s表示某个客户端对象引用
                String remoteIP = s.getInetAddress().getHostAddress();
                // 获取远程客户端端口号
                int remotePort = s.getPort();
                //int localPort = s.getLocalPort(); // 获取本地端口（文件存储服务器所占用的端口）
                System.out.println("远程客户端IP地址：" + remoteIP + ",远程客户端端口是：" + remotePort);
                //实现客户端将本地文件上传到服务器上某个指定文件夹中保存
                /*
                 七个参数
                    int corePoolSize: 核心线程池的大小    core核心   Pool 池子   Size 大小
                    int maximumPoolSize: 最大线程池的大小
                    long keepAliveTime : 当线程池中线程数大于corePoolSize，
                                         并且没有可执行任务时大于corePoolSize那部分线程的存活时间
                    TimeUnit unit : 时间单位
                    BlockingQueue<Runnable> workQueue:  用来暂时保存任务的工作队列
                    ThreadFactory threadFactory: 线程工厂提供线程的创建方式，默认使用Executors.defaultThreadFactory()
                    RejectedExecutionHandler handler 当线程池所处理的任务数超过其承载容量或关闭后继续有任务提交时，所调用的拒绝策略
                 */
                //创建一个线程池对象
                ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                        2, // 核心线程数 2   某个部门有2名正式员工
                         5, // 最大线程池 5    某个部门3名临时工+2名正式员工=5名员工
                         1, //  临时工没有可执行任务时存活时间   1分钟
                        TimeUnit.MINUTES,  //时间单位  以分钟为单
                        new LinkedBlockingQueue<>(3),  // 工作队列 容量初始化3
                        Executors.defaultThreadFactory(), //线程工厂创建线程对象
                        new ThreadPoolExecutor.AbortPolicy()  //拒绝策略
                );

                //提供任务给线程池执行

                // 传入是实现了Runnable接口实现类对象
                threadPoolExecutor.submit(new ReceiveDataTask(s));

                //3.关闭线程池
                //threadPoolExecutor.shutdown();
            }
        }
        catch (Exception err) {
            err.printStackTrace();
        } finally {
            if(fileServer != null) {
                try {
                    fileServer.close();
                    System.out.println("文件存储服务器已关闭！");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //使用静态内部类方式实现Runnable接口，从而创建线程
    private static final class ReceiveDataTask implements Runnable {

        private final Socket thatSocket;  //表示某个与服务器成功连接的客户端对象

        //构造方法初始化thatSocket客户端对象
        public ReceiveDataTask(final Socket thatSocket) {
            this.thatSocket = thatSocket;
        }

        //线程执行体
        @Override
        public void run() {
            //接收客户端发送来的文件名称、文件大小、文件数据块。
            // 利作线程池（高度封装工具类）里面工作线程为成功连接客户端服务
            //打印当前线程名
            System.out.println("当前线程池的名称：" + Thread.currentThread().getName());
            // 创建一个文件对象，关联上服务器保存文件目录路径
            File dirFile = new File(UPLOAD_SAVE_PATH);
            if(! dirFile.exists()) {  //如果此目录不存在，创建它
                dirFile.mkdirs(); // 创建此目录
            }
            while (true) {  // 死循环的作用，服务器多次和客户端进行数据传输
                DataInputStream dis = null;
                DataOutputStream dos = null;
                try {
                    dis =  new DataInputStream(this.thatSocket.getInputStream());
                    String fileName = dis.readUTF(); //读取客户端上传的文件名称
                    long fileLength = dis.readLong();//读取客户端上传文件大小(以字节为单位)
                    System.out.println("文件名称：" + fileName + ",文件大小：" + fileLength + "(字节)");
                    dos = new DataOutputStream(new FileOutputStream(new File(dirFile,fileName)));
                    //读取数据块
                    byte[] buffer = new byte[1024] ; // 创建一个临时保存数据内存区域
                    int len = -1;  //每次实际读取的字节数
                    int dataSize = 0;  //统计总的字节数
                    while ((len = dis.read(buffer)) != -1) {
                        dataSize += len;
                        dos.write(buffer,0,len); // 将每次实际读取数据块(1kb)写入到服务器指定位置
                        dos.flush(); //flush()方法用于强制将内存缓冲区的数据流刷入文件
                        if(dataSize == fileLength) {
                            break;
                        }
                    } //#end while


                    System.out.println("统计总的字节大小是： " + dataSize );
                    // TODO: 文件上传成功，给客户端回复成功提示消息
                }
                catch (IOException ex) {
                    System.out.println("工作线程》》》IO异常，错误信息是：" + ex.getMessage());
                    System.out.println(this.thatSocket.getRemoteSocketAddress() + "客户端断开啦！！！");
                    //ex.printStackTrace(); //打印异常堆栈异常信息，为了排查错误
                    if(this.thatSocket != null ) {
                        try {
                            this.thatSocket.close();
                        } catch (IOException e) {
                            System.out.println("》》》》》》》》》》》》》》》》》");
                        }
                    }
                    break;
                }
                finally {
                    if (dis != null) {
                        try {
                            dis.close();
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    if (dos != null) {
                        try {
                            dos.close();
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            }
        }
    }
}
