package org.example.Jdbc;

import java.math.BigDecimal;
import java.sql.*;

public class JdbcTransaction {
    // 事务：作用    保证数据强一致性

    // 模拟转账
    /*
      MySQL管理事务三条SQL语句
       begin/start transaction; 开启一个新的事务
       commit     提交事务
       rollback   回滚事务

       set autocommit=0  关闭自动提交
       set autocommit=1  开启自动提交
     */
    private static final String URL = "jdbc:mysql:///hospital_db?serverTimezone=Asia/Shanghai";
    //MySQL驱动类程序
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String USER = "root";
    private static final String PASSWORD = "wangquanquan317";

    static{
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    public static Object scalar(Connection conn,String sql,Object ... args) {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = conn.prepareStatement(sql);
            stmt.clearParameters();
            // 给占位符?赋值
            for (int i = 0; i < args.length; i++) {
                stmt.setObject(i+1,args[i]);
            }
            rs = stmt.executeQuery();
            if(rs.next()) {
                Object result = rs.getObject(1);
                return result;
            }
            else {
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            if(rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static int update(Connection conn,String sql,Object ... args) {
        PreparedStatement stmt = null;
        try {
            stmt = conn.prepareStatement(sql);
            stmt.clearParameters();
            // 给占位符?赋值
            for (int i = 0; i < args.length; i++) {
                stmt.setObject(i+1,args[i]);
            }
            return stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        } finally {
            if(stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                   e.printStackTrace();
                }
            }
        }
    }


    //转账方法
    public static void transfer(String toAccount,
                                String fromAccount,
                                BigDecimal money){
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = DriverManager.getConnection(URL,USER,PASSWORD);
            conn.setAutoCommit(false); // 阻止事务自动提交模式
            String sql1 = "select balance from account where cardNo=?";
            String sql2 = "update account set balance=balance - ? where cardNo=?";
            String sql3 = "update account set balance=balance + ? where cardNo=?";
            String sql4 = "insert into trade_record(trade_type,trade_money,cardNo)values(?,?,?)";

            BigDecimal balance = (BigDecimal)scalar(conn,sql1,toAccount);
            //System.out.println("实际的数据类型 ：" + money.getClass().getName());
            if(money.compareTo(balance) == 1) {  // 10000 > 9999
                throw new RuntimeException("余额不足！");
            }
            update(conn,sql2,money,toAccount);
            update(conn,sql4,"支取",money,toAccount);

            // 模拟异常
            //int a = 10 / 0; // 除数为0异常


            update(conn,sql3,money,fromAccount);
            update(conn,sql4,"存入",money,fromAccount);

            conn.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            if (conn != null) {
                try {
                    conn.rollback();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        } finally {
            try {
                if(conn != null) {
                    conn.setAutoCommit(true); // 启用事务自动提交模式
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        transfer("1100 4545","1100 9898",new BigDecimal("4000.0"));
    }

}
