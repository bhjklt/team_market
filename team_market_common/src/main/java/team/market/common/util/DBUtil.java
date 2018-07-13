package team.market.common.util;

import org.apache.commons.dbcp2.BasicDataSource;
import team.market.common.config.DBConf;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class DBUtil {
    private static Properties prot = new Properties();

    private static BasicDataSource adataSource = new BasicDataSource();

    private static BasicDataSource mdataSource = new BasicDataSource();

    private static DBConf adbConf = null;

    private static DBConf mdbConf = null;

    static {
        try {
            prot.load(DBUtil.class.getClassLoader().getResourceAsStream("dbconfig.properties"));

            adbConf = new DBConf(prot.getProperty("url"), prot.getProperty("ausername"), prot.getProperty("apassword"), prot.getProperty("driverClassName"));
            adataSource.setUrl(adbConf.getUrl());
            adataSource.setUsername(adbConf.getUsername());
            adataSource.setPassword(adbConf.getPassword());
            adataSource.setDriverClassName(adbConf.getDriverClassName());

            mdbConf = new DBConf(prot.getProperty("url"), prot.getProperty("mcusername"), prot.getProperty("mcpassword"), prot.getProperty("driverClassName"));
            mdataSource.setUrl(mdbConf.getUrl());
            mdataSource.setUsername(mdbConf.getUsername());
            mdataSource.setPassword(mdbConf.getPassword());
            mdataSource.setDriverClassName(mdbConf.getDriverClassName());
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static Connection getConnection(String databaseName) {
        Connection conn = null;
        try {
            if(databaseName.equals("ADB")){
                conn= adataSource.getConnection();
            }else if(databaseName.equals("MDB")){
                conn= mdataSource.getConnection();
            }
            if(conn == null)
                conn = getConnectionWithJDBC(databaseName);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return conn;
    }

    public static Connection getConnectionWithJDBC(String databaseName) {
        Connection conn = null;
        try {
            if(databaseName.equals("ADB")){
                Class.forName(adbConf.getDriverClassName());
                conn = DriverManager.getConnection(adbConf.getUrl(),adbConf.getUsername(),adbConf.getPassword());
            }else if(databaseName.equals("MDB")){
                Class.forName(mdbConf.getDriverClassName());
                conn = DriverManager.getConnection(mdbConf.getUrl(),mdbConf.getUsername(),mdbConf.getPassword());
            }
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
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
