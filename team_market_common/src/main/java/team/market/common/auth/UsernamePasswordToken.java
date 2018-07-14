package team.market.common.auth;

public class UsernamePasswordToken implements AuthenticationToken {

    private String username;
    private String password;

    public UsernamePasswordToken() {

    }

    public UsernamePasswordToken(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getPrincipal() {
        return this.username;
    }

    public String getCredentials() {
        return this.password;
    }

}
