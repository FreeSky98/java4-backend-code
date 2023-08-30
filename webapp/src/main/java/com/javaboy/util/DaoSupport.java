package com.javaboy.util;

import com.javaboy.model.Student;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 数据库操作辅助类
 * @author lds
 */
public class DaoSupport {
    // 数据库连接字符串
    private static final String url = "jdbc:mysql://localhost:3306/hospital_db?serverTimezone=Asia/Shanghai";
    // MySQL驱动程序类
    private static final String driver = "com.mysql.cj.jdbc.Driver";
    // 数据库用户名
    private static final String user = "root";
    // 密码
    private static final String pwd = "wangquanquan317";

    // 静态代码块
    static {
        try {
            // 加载JDBC驱动类
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace(); //打印异常堆栈信息
            System.out.println("加载驱动程序类出错！");
        }
    }

    //获取连接对象
    private Connection getConnection() {
        try {
            Connection connection = DriverManager.getConnection(url,user,pwd);
            return connection;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("连接数据库出错");
            return null;
        }
    }

    //关闭资源
    private void closeAll(ResultSet rs, Statement stmt,Connection conn) {
        if(rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("关闭结果集对象出错！");
            }
        }
        if(stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("关闭预编译对象出错！");
            }
        }
        if(conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("关闭数据库连接对象出错！");
            }
        }
    }

    /**
     *  通用查询方法
     * @param clazz 某个类型Class对象
     * @param sql select语句
     * @param paramValues 可变参数值
     * @return 返回强类型对象集合
     * @param <T> 参数化类型
     */
    public <T> List<T> query(Class<T> clazz,String sql,Object ... paramValues) {
        List<T> list = new ArrayList<>();
        Connection conn = getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = conn.prepareStatement(sql);
            if(paramValues != null && paramValues.length > 0) {
                for (int i = 0; i < paramValues.length; i++) {
                    stmt.setObject(i+1, paramValues[i]);
                }
            }
            rs = stmt.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            while (rs.next()) {
                T obj = clazz.getDeclaredConstructor().newInstance();
                int columnCount = rsmd.getColumnCount();
                for (int i = 1; i <= columnCount; i++) {
                    // 获取列名或列的别名
                    String columnLabel = rsmd.getColumnLabel(i);
                    // 获取列值
                    Object columnValue = rs.getObject(columnLabel);
                    // 通过反射技术根据列名获取指定Field
                    Field field = clazz.getDeclaredField(columnLabel);
                    field.setAccessible(true);
                    field.set(obj, columnValue);
                }
                list.add(obj);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("操作数据库出错！");
        }
        finally {
            // 释放所有资源
            closeAll(rs, stmt, conn);
        }
        return list;
    }

    /**
     * 返回单个实体对象
     * @param clazz 某个类型Class对象
     * @param sql select语句
     * @param throwEx 控制是否抛出异常
     * @param paramValues 可变的参数值数组
     * @return 返回单个实体对象
     * @param <T> 参数化类型
     */
    public <T>  T queryOne(Class<T> clazz,String sql,boolean throwEx,Object ... paramValues) {
        List<T> list = this.query(clazz, sql, paramValues);
        int size = list.size();
        if(size == 1) {
            return list.get(0);
        }
        else if(size > 1) {
            if (throwEx) {
                throw new RuntimeException("Expected one result (or null) to be returned by queryOne(), but found: " + list.size());
            }
            return list.get(0);
        }
        return null;
    }

    /**
     * 执行插入、更新、删除操作的实用方法
     * @param sql 插入、更新、删除的SQL语句，不能执行查询SQL语句！！
     * @param paramValues 可变的参数值数组
     * @return
     */
    public int update(String sql,Object ... paramValues) {
        Connection conn = getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = conn.prepareStatement(sql);
            if(paramValues != null && paramValues.length > 0) {
                // 设置占位符(?)参数值
                for (int i = 0; i < paramValues.length; i++) {
                    stmt.setObject(i+1, paramValues[i]);
                }
            }
           return stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            //System.out.println("操作数据库异常！");
            //return -1;
            throw new RuntimeException("操作数据库异常!",e);
        } finally {
            // 释放所有资源
            closeAll(null, stmt, conn);
        }
    }
}
