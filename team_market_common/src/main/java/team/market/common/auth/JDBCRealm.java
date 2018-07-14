package team.market.common.auth;

import team.market.common.auth.dao.PermissionDao;
import team.market.common.auth.dao.UserDao;
import team.market.common.auth.dao.UserPermissionDao;
import team.market.common.auth.exception.CredentialsException;
import team.market.common.auth.exception.DisabledAccountException;
import team.market.common.auth.exception.UnknownAccountException;
import team.market.common.auth.pojo.Permission;
import team.market.common.auth.pojo.User;
import team.market.common.auth.pojo.UserPermission;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class JDBCRealm implements AuthorizingRealm {

    private static UserDao userDao = new UserDao();
    private static PermissionDao permissionDao = new PermissionDao();
    private static UserPermissionDao userPermissionDao = new UserPermissionDao();

    @Override
    public boolean isPermitted(Permission permission) {
        Map<String, String> conditions = new HashMap<>();
        conditions.put("permission", permission.getPermission());
        List<Permission> permissions = permissionDao.findByCondition(conditions);
        if (permissions.size() > 0) {
            conditions.clear();
            conditions.put("pid", permissions.get(0).getId());
            conditions.put("user_id", ((User)SecurityUtils.getSubject().getAuthorizingInfo()).getId());
            List<UserPermission> userPermissions = userPermissionDao.findByCondition(conditions);
            if (userPermissions.size() > 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean isPermittedAll(Set<Permission> permissions) {
        for (Permission permission: permissions) {
            if (!isPermitted(permission))
                return false;
        }
        return true;
    }

    @Override
    public String getName() {
        return "JDBC Realm";
    }

    @Override
    public boolean support(AuthenticationToken token) {
        return token instanceof UsernamePasswordToken;
    }

    @Override
    public AuthorizingInfo getAuthorizingInfo(AuthenticationToken token) {
        Map<String, String> conditions = new HashMap<>();
        conditions.put("username", ((UsernamePasswordToken) token).getPrincipal());
        List<User> users = userDao.findByCondition(conditions);
        if (users.size() == 0) {
            throw new UnknownAccountException();
        } else if (!users.get(0).getPassword().equals(((UsernamePasswordToken) token).getCredentials())) {
            throw new CredentialsException();
        } else if (users.get(0).getStatus().equals(User.FORBIDDEN)) {
            throw new DisabledAccountException();
        }
        return users.get(0);
    }

}
