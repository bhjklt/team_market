package team.market.common.auth;

import team.market.common.auth.pojo.Permission;

import java.util.Set;

public interface AuthorizingInfo {

    Object getPrincipal();

    Object getCredentials();

    Set<Permission> getPermissions();

}
