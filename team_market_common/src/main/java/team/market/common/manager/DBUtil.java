package team.market.common.manager;

import org.apache.commons.dbcp2.BasicDataSource;
import team.market.common.config.DatabaseConfiguration;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;
/**
 * @author Justin
 */
public class DBUtil {

    private static final String DEFAULT_CONFIGURATION_FILE = "/dbconf.properties";

    private static DatabaseConfiguration databaseConfiguration = null;

    public static BasicDataSource dataSource = new BasicDataSource();

    static {
        initializeDatabaseConfiguration();
        initializeDataSource();
    }

    private static void initializeDatabaseConfiguration() {
        InputStream configurationStream = DBUtil.class.getResourceAsStream(DEFAULT_CONFIGURATION_FILE);
        databaseConfiguration = null;
        if (configurationStream != null) {
            Properties configurationProperties = new Properties();
            try {
                configurationProperties.load(configurationStream);
                databaseConfiguration = new DatabaseConfiguration(
                        configurationProperties.getProperty("driverClass"),
                        configurationProperties.getProperty("url"),
                        configurationProperties.getProperty("username"),
                        configurationProperties.getProperty("password"),
                        Integer.valueOf(configurationProperties.getProperty("initialSize"))
                );
            } catch (IOException e) {
                System.out.println("Can not load database configuration, " + e.toString());
            }
        }
        if (databaseConfiguration == null) {
            databaseConfiguration = DatabaseConfiguration.newDefaultInstance();
        }
    }

    private static void initializeDataSource() {
        dataSource = new BasicDataSource();
        dataSource.setDriverClassName(databaseConfiguration.getDriverClassName());
        dataSource.setUrl(databaseConfiguration.getUrl());
        dataSource.setUsername(databaseConfiguration.getUsername());
        dataSource.setPassword(databaseConfiguration.getPassword());
        dataSource.setInitialSize(databaseConfiguration.getInitialSize());
    }

    /**
     * You can use this method to get database connection
     *
     * get connection with DBCP is the first choice, if failed will use the common way to get connection.
     *
     * @return Database connection
     */
    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = getConnectionWithDBCP();
        } catch (SQLException e) {
            System.err.println("Can not create connection with DBCP, " + e.toString());
        }
        if (connection == null) {
            try {
                Class.forName(databaseConfiguration.getDriverClassName());
                connection = DriverManager.getConnection(databaseConfiguration.getUrl(), databaseConfiguration.getUsername(), databaseConfiguration.getPassword());
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }

    private static Connection getConnectionWithDBCP() throws SQLException {
        Connection connection = null;
        if (dataSource != null) {
            connection = dataSource.getConnection();
        }
        return connection;
    }

    public static void close(Connection connection, Statement statement, ResultSet resultSet) {
        try {
            if (connection != null) connection.close();
            if (statement != null) statement.close();
            if (resultSet != null) resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void close(Connection connection, Statement statement) {
        close(connection, statement, null);
    }

    public static void close(Connection connection) {
        close(connection, null, null);
    }


}
