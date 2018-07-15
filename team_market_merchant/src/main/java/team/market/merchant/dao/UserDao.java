package team.market.merchant.dao;

import team.market.common.dao.BaseDao;
import team.market.merchant.pojo.User;

import java.io.Serializable;

public interface UserDao extends BaseDao<User,Serializable> {

    public User findUser(String username);
}
