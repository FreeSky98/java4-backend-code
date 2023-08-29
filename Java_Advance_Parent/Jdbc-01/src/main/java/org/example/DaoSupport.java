package org.example;

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
            System.out.println("加载驱动程序类出错！");
        }
    }

    //获取连接对象
    public Connection getConnection() {
        try {
            return DriverManager.getConnection(url,user,pwd);
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
                System.out.println("关闭结果集对象出错！");
            }
        }
        if(stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {
                System.out.println("关闭预编译对象出错！");
            }
        }
        if(conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
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
    protected <T> List<T> query(Class<T> clazz,String sql,Object ... paramValues) {
        List<T> list = new ArrayList<>();
        Connection conn = getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            if (conn != null) {
                stmt = conn.prepareStatement(sql);
            }
            if(paramValues != null && paramValues.length > 0) {
                for (int i = 0; i < paramValues.length; i++) {
                    if (stmt != null) {
                        stmt.setObject(i+1, paramValues[i]);
                    }
                }
            }
            if (stmt != null) {
                rs = stmt.executeQuery();
            }
            ResultSetMetaData rsmd = null;
            if (rs != null) {
                rsmd = rs.getMetaData();
            }
            if (rs != null) {
                while (rs.next()) {
                    T obj = clazz.getDeclaredConstructor().newInstance();
                    int columnCount = 0;
                    if (rsmd != null) {
                        columnCount = rsmd.getColumnCount();
                    }
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
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("操作数据库出错！");
        }
        finally {
            closeAll(rs,stmt,conn);
        }
        return list;
    }

    public <T> T queryOne(Class<T> clazz,String sql,boolean throwEx,Object ... paramValues) {
        List<T> list = this.query(clazz,sql,paramValues);
        int size = list.size();
        if (size == 1) {
            return list.get(0);
        } else if (size > 1) {
            if (throwEx) {
                throw new RuntimeException("Expected one result (or null) to be returned by queryOne(), but found: " + list.size());
            }
            return list.get(0);
        }
        return null;
    }


    public int update(String sql,Object ... paramValues) {
        Connection conn = getConnection();
        PreparedStatement stmt = null;
        try {
            if (conn != null) {
                stmt = conn.prepareStatement(sql);
            }
            if (paramValues != null && paramValues.length > 0) {
                for (int i = 0; i < paramValues.length; i++) {
                    if (stmt != null) {
                        stmt.setObject(i+1,paramValues[i]);
                    }
                }
            }
            if (stmt != null) {
                return stmt.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("操作数据库出错！");
        } finally {
            closeAll(null,stmt,conn);
        }
        return -1;
    }


    public static void main(String[] args) {
        DaoSupport ds = new DaoSupport();
        String sql = "SELECT id,`name`,age,sex,dept,address FROM student";
        List<Student> list = ds.query(Student.class, sql);
        list.forEach(System.out::println);
    }
}

