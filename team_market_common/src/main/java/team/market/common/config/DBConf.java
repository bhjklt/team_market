package team.market.common.config;

public class DBConf {
    private String id;
    private String url;
    private String username;
    private String password;
    private String driverClassName;

    public DBConf(){

    }

    public DBConf(String id, String url, String username, String password, String driverClassName) {
        super();
        this.id = id;
        this.url = url;
        this.username = username;
        this.password = password;
        this.driverClassName = driverClassName;
    }

    public String getId(){
        return id;
    }
    public void setId(String id){ this.id = id; }
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

}
