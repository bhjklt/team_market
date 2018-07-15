package team.market.common.auth.service;

import team.market.common.auth.dao.PermissionDao;
import team.market.common.auth.pojo.Permission;
import team.market.common.service.BaseService;
import team.market.common.util.UUIDUtils;
import java.util.List;
import java.util.Map;

public class PermissionService implements BaseService<Permission, String> {

    private static PermissionDao permissionDao = new PermissionDao();

    @Override
    public Permission find(String s) {
        return permissionDao.find(s);
    }

    @Override
    public List<Permission> findAll() {
        return permissionDao.findAll();
    }

    @Override
    public Permission save(Permission permission) {
        permission.setId(UUIDUtils.getUUID());
        return permissionDao.save(permission);
    }

    @Override
    public boolean delete(String s) {
        return permissionDao.delete(s);
    }

    @Override
    public List<Permission> findByCondition(Map map) {
        return permissionDao.findByCondition(map);
    }

    @Override
    public boolean update(Permission permission) {
        return permissionDao.update(permission);
    }

}
