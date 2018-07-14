package team.market.common.auth;

import team.market.common.auth.exception.UnauthorizedException;
import team.market.common.auth.exception.UnknownAccountException;
import team.market.common.auth.pojo.Permission;

import java.util.Set;

public class SecurityManager {

    private Set<Realm> realms;

    public SecurityManager(Set<Realm> realms) {
        this.realms = realms;
    }

    public AuthorizingInfo login(AuthenticationToken token) {
        AuthorizingInfo authorizingInfo = null;
        for (Realm realm: realms) {
            if (realm.support(token)) {
                authorizingInfo = realm.getAuthorizingInfo(token);
            }
            if (authorizingInfo != null)
                return authorizingInfo;
        }
        throw new UnknownAccountException();
    }

    public void checkPermission(Permission permission) {
        if (!isPermitted(permission))
            throw new UnauthorizedException();
    }

    public void checkPermissions(Set<Permission> permissions) {
        if (!isPermittedAll(permissions))
            throw new UnauthorizedException();
    }

    public boolean isPermitted(Permission permission) {
        for (Realm realm: realms) {
            if (realm instanceof AuthorizingRealm) {
                if (((AuthorizingRealm) realm).isPermitted(permission))
                    return true;
            }
        }
        return false;
    }

    public boolean isPermittedAll(Set<Permission> permissions) {
        for (Permission permission: permissions) {
            if (!isPermitted(permission)) {
                return false;
            }
        }
        return true;
    }

}
