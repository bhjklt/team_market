package team.market.common.auth;

public interface AuthenticationToken {

    Object getPrincipal();

    Object getCredentials();

}
