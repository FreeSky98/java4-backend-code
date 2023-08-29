package org.example.Jdbc;

import java.sql.*;
import java.util.Scanner;

public class Jdbc_03 {
    private static final String driverClass = "com.mysql.cj.jdbc.Driver";
    private static final String USER = "root";
    private static final String PASSWORD = "wangquanquan317";
    private static final String URL = "jdbc:mysql:///stu_db?serverTimezone=Asia/Shanghai";//数据库连接地址

    static {
        try {
            Class.forName(driverClass);
        } catch (ClassNotFoundException e) {
            System.out.println("驱动加载失败！");
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            System.out.println("操作数据库出错");
            e.printStackTrace();
            return null;
        }
    }

    public void closeAll(ResultSet rs,Statement stmt,Connection conn) {
        if (null != rs) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (null != stmt) {
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (null != conn) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws SQLException {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入学号：");
        int id = input.nextInt();

        System.out.println("请输入出生日期：");
        String birthDate = input.next();

        System.out.println("请输入手机号：");
        String phone = input.next();

        System.out.println("请输入邮箱：");
        String email = input.next();

        Jdbc_03 o_OII = new Jdbc_03();
        //获取数据库连接对象
        Connection connection = o_OII.getConnection();
        System.out.println(!connection.isClosed() ? "连接成功" : "连接失败");
        String sql = "update student set birth_date=?,phone=?,email=? where id=?";
        PreparedStatement ps = connection.prepareStatement(sql);

        ps.setString(1,birthDate);
        ps.setString(2,phone);
        ps.setString(3,email);
        ps.setInt(4,id);
        int rows = ps.executeUpdate();//执行DML语句，返回影响行数
        if (rows > 0) {
            System.out.println("更新成功！");
        }
        o_OII.closeAll(null,ps,connection);
    }
}
