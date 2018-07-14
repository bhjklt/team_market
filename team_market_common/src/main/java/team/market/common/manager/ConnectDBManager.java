package team.market.common.manager;

import org.apache.commons.dbcp2.BasicDataSource;
import team.market.common.config.DBConf;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * @author Justin
 */
public class ConnectDBManager {

    public static BasicDataSource dataSource = new BasicDataSource();

    private static DBConf dbConf;

    private static String path;

    public ConnectDBManager(String path){
         this.path = path;
         this.initDataSource();
    }

    public static void initDataSource( ) {
        Properties prot = new Properties();
        try {
            prot.load(new FileInputStream(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        dbConf = new DBConf(prot.getProperty("url"), prot.getProperty("username"), prot.getProperty("password"), prot.getProperty("driverClassName"));
        dataSource.setUrl(dbConf.getUrl());
        dataSource.setUsername(dbConf.getUsername());
        dataSource.setPassword(dbConf.getPassword());
        dataSource.setDriverClassName(dbConf.getDriverClassName());
    }


}
