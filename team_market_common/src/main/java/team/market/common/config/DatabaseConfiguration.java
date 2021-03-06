package team.market.common.config;

/**
 * @author Justin
 */
public class DatabaseConfiguration {
    private String url;
    private String username;
    private String password;
    private String driverClassName;
    private Integer initialSize;

    public static DatabaseConfiguration newDefaultInstance() {
        return new DatabaseConfiguration("oracle.jdbc.driver.OracleDriver", "jdbc:oracle:thin:@localhost:1521:xe", "SYSTEM", "", 20);
    }


    public DatabaseConfiguration(){

    }

    public DatabaseConfiguration(String driverClassName, String username, String password, String url, Integer initialSize) {
        super();
        this.driverClassName = driverClassName;
        this.username = username;
        this.password = password;
        this.url = url;
        this.initialSize = initialSize;
    }

    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getDriverClassName() {
        return driverClassName;
    }
    public void setDriverClassName(String driverClassName) {
        this.driverClassName = driverClassName;
    }
    public Integer getInitialSize() {
        return initialSize;
    }
    public void setInitialSize(Integer initialSize) {
        this.initialSize = initialSize;
    }
}
