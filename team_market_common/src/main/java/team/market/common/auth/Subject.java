package team.market.common.auth;

import team.market.common.auth.pojo.Permission;
import team.market.common.auth.pojo.User;
import team.market.common.auth.pojo.UserPermission;
import team.market.common.auth.service.UserPermissionService;

import java.util.Set;

public class Subject {

    private SecurityManager securityManager;
    private AuthorizingInfo authorizingInfo = null;
    private static UserPermissionService userPermissionService = new UserPermissionService();

    public Subject(SecurityManager securityManager) {
        this.securityManager = securityManager;
    }

    public void setAuthorizingInfo(AuthorizingInfo authorizingInfo) {
        this.authorizingInfo = authorizingInfo;
    }

    public AuthorizingInfo getAuthorizingInfo() {
        return authorizingInfo;
    }

    public SecurityManager getSecurityManager() {
        return securityManager;
    }

    public AuthorizingInfo login(AuthenticationToken token) {
        this.authorizingInfo = securityManager.login(token);
        return this.authorizingInfo;
    }

    public void logout() {
        this.authorizingInfo = null;
    }

    public boolean isLogged() {
        return this.authorizingInfo != null;
    }

    public void checkPermission(Permission permission) {
        securityManager.checkPermission(permission);
    }

    public void checkPermissions(Set<Permission> permissions) {
        securityManager.checkPermissions(permissions);
    }

    public boolean isPermitted(Permission permission) {
        return securityManager.isPermitted(permission);
    }

    public boolean isPermittedAll(Set<Permission> permissions) {
        return securityManager.isPermittedAll(permissions);
    }

    public void addPermission(Permission permission) {
        if (isLogged()) {
            userPermissionService.save(new UserPermission(((User)authorizingInfo).getId(), permission.getId()));
        }
    }

    public void removePermission(Permission permission) {
        if (isLogged()) {
            userPermissionService.deleteByUserIdAndPId(((User)authorizingInfo).getId(), permission.getId());
        }
    }

}
