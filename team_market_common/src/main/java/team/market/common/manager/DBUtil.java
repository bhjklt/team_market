package team.market.common.manager;

import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author Justin
 */
public class DBUtil {

    public static BasicDataSource dataSource = new BasicDataSource();

    static {
        String path = DBUtil.class.getClassLoader().getResource("dbconf.properties").getPath();
        //System.out.print("path:"+path);
        ConnectDBManager cm = new ConnectDBManager(path);
        dataSource = cm.dataSource;
    }

    public static Connection getConnection() {
        Connection conn = null;
        try {
            conn= dataSource.getConnection();
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
