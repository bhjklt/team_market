package team.market.common.auth;

import java.util.Set;

public interface AuthorizingInfo {

    Object getPrincipal();

    Object getCredentials();

    Set<Permission> getPermissions();

}
