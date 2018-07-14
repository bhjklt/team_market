package team.market.common.manager;

import org.apache.commons.dbcp2.BasicDataSource;
import team.market.common.config.DBConf;

import java.io.InputStream;
import java.util.Map;

public class ConnectDBManager {

    public static BasicDataSource aDataSource = new BasicDataSource();

    public static BasicDataSource mcDataSource = new BasicDataSource();

    private static DBConf aDbConf = null;

    private static DBConf mcDbConf = null;

    static {
        InputStream in = ConnectDBManager.class.getClassLoader().getResourceAsStream("dbconf.xml");
        Map<String,DBConf> dbConfs = SaxManager.getDbConfs(in);

        aDbConf =  dbConfs.get("a");
        aDataSource.setUrl(aDbConf.getUrl());
        aDataSource.setUsername(aDbConf.getUsername());
        aDataSource.setPassword(aDbConf.getPassword());
        aDataSource.setDriverClassName(aDbConf.getDriverClassName());

        mcDbConf = dbConfs.get("mc");
        mcDataSource.setUrl(mcDbConf.getUrl());
        mcDataSource.setUsername(mcDbConf.getUsername());
        mcDataSource.setPassword(mcDbConf.getPassword());
        mcDataSource.setDriverClassName(mcDbConf.getDriverClassName());

    }
}
