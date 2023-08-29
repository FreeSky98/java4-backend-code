package org.example.Jdbc;

import java.sql.*;
import java.util.Scanner;

public class Jdbc_04 {
    // 驱动程序类
    private static final String driverClass  = "com.mysql.cj.jdbc.Driver";
    //数据库连接地址
    //private static final String url = "jdbc:mysql:///stu_db?serverTimezone=Asia/Shanghai";
    private static final String url = "jdbc:mysql://127.0.0.1:3306/stu_db?serverTimezone=Asia/Shanghai";
    //数据库用户名
    private static final String user = "root";
    //密码
    private static final String password = "root";

    // 静态代码块  ：随着类的加载而加载，仅执行一次
    static {
        try {
            //加载驱动程序类(mysql)
            Class.forName(driverClass);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("加载MySQL驱动类失败");
        }
    }//Excel表格？

    //获得数据库连接对象
    public Connection getConnection() {
        try {
            /*
            DriverManager(驱动管理类)：
            管理不同关系型数据库（比如：Oracle、MySQL、SQL Server等）驱动程序大管家。
             */
            Connection conn =
                    DriverManager.getConnection(url,user,password);
            return conn;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("操作数据库出错");
            return null;
        }
    }
    //释放所有资源
    public void closeAll(ResultSet rs, Statement stmt,Connection conn){
        if(null != rs) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(null != stmt) {
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(null != conn) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws SQLException {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入学号：");//通过主键(学号)或唯一键来作为删除条件
        Integer id = input.nextInt();


        Jdbc_04 _db = new Jdbc_04();
        //获取数据库连接对象
        Connection conn = _db.getConnection();
        System.out.println(conn.isClosed() == false ? "连接成功！" : "连接失败");
        String sql = "delete from student where id=?";
        PreparedStatement ps = conn.prepareStatement(sql);
        // 给占位符?设置参数值

        ps.setInt(1,id);
        //executeUpdate()执行DML语句，返回受DML语句影响的行数，如果非0，表示成功，否则失败
        int rows = ps.executeUpdate();
        if(rows > 0) System.out.println("删除学生成功！");

        _db.closeAll(null, ps, conn);
    }
}
