package team.market.common.auth;

public interface Realm {

    String getName();

    boolean support(AuthenticationToken token);

    AuthorizingInfo getAuthorizingInfo(AuthenticationToken token);

}
