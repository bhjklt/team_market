package team.market.common.auth;

import team.market.common.auth.pojo.Permission;

import java.util.Set;

public interface Authorizer {

    boolean isPermitted(Permission permission);

    boolean isPermittedAll(Set<Permission> permissions);

}
