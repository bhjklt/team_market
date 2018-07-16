package team.market.common.auth.service;

import team.market.common.auth.dao.UserPermissionDao;
import team.market.common.auth.pojo.UserPermission;
import team.market.common.service.BaseService;
import team.market.common.util.UUIDUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserPermissionService implements BaseService<UserPermission, String> {

    private static UserPermissionDao userPermissionDao = new UserPermissionDao();

    @Override
    public UserPermission find(String s) {
        return userPermissionDao.find(s);
    }

    @Override
    public List<UserPermission> findAll() {
        return userPermissionDao.findAll();
    }

    @Override
    public UserPermission save(UserPermission userPermission) {
        userPermission.setId(UUIDUtils.getUUID());
        return userPermissionDao.save(userPermission);
    }

    @Override
    public boolean delete(String s) {
        return userPermissionDao.delete(s);
    }

    @Override
    public List<UserPermission> findByCondition(Map map) {
        return userPermissionDao.findByCondition(map);
    }

    @Override
    public boolean update(UserPermission userPermission) {
        return userPermissionDao.update(userPermission);
    }

    public boolean deleteByUserIdAndPId(String userId, String pId) {
        Map<String, String> conditions = new HashMap<>();
        conditions.put("user_id", userId);
        conditions.put("pid", pId);
        List<UserPermission> userPermissions = userPermissionDao.findByCondition(conditions);
        if (userPermissions.size() > 0) {
            return delete(userPermissions.get(0).getId());
        }
        return false;
    }
}
