package team.market.customer.util;

import team.market.common.manager.ConnectDBManager;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtil {
    public static Connection getConnection() {
        Connection conn = null;
        try {
            conn= ConnectDBManager.mcDataSource.getConnection();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return conn;
    }

    public static void close(Connection conn, Statement st, ResultSet rs) {
        try {
            if(rs!=null)rs.close();
            if(st!=null) st.close();
            if(conn!=null) conn.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void close(Connection conn,Statement st) {
        try {
            if(st!=null) st.close();
            if(conn!=null) conn.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}
