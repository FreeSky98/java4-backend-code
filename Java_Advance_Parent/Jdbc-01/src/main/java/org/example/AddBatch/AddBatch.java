package org.example.AddBatch;

import org.example.DaoSupport;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AddBatch {
    private static final long COUNT = 5000;
    private static final DaoSupport dao = new DaoSupport();
    public static void addBatch() {
        long start = System.currentTimeMillis();
        Connection conn = null;
        PreparedStatement ps = null;
        conn = dao.getConnection();
        try {
            conn.setAutoCommit(false);
            String sql = "";
        } catch (SQLException e) {
            e.printStackTrace();
            if (conn != null) {
                try {
                    conn.rollback();
                } catch (SQLException ex) {
                    e.printStackTrace();
                }
            }
        } finally {
            if (ps != null) {
                try {

                } catch (Exception e) {

                }
            }
        }

        long end = System.currentTimeMillis();
        System.out.println("数据插入耗时："+(end-start)+"ms");
    }
    public static void main(String[] args) {
        addBatch();
    }
}
