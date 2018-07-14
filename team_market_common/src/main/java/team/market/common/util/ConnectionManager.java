package team.market.common.util;

import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionManager {
    private static ThreadLocal<Connection> threadLocal = new ThreadLocal<Connection>();

    public static Connection getInstance() {
        Connection conn = threadLocal.get();
        if (conn == null) {
            conn = DBUtil.getConnection();//获取数据库连接对象
            threadLocal.set(conn);
        }
        return conn;
    }

    public static void begin() {
        Connection conn = threadLocal.get();
        if (conn == null) {
            conn = getInstance();
            try {
                conn.setAutoCommit(false);
                threadLocal.set(conn);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    public static void commit() {
        Connection conn = threadLocal.get();
        if (conn == null) {
            return;//no begin
        }
        try {
            conn.commit();
            conn.close();
            threadLocal.remove();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static void rollback() {
        Connection conn = threadLocal.get();
        if (conn == null) {
            return;//no begin
        }
        try {
            conn.rollback();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
