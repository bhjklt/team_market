package team.market.merchant.service;

import team.market.common.util.UUIDUtils;
import team.market.merchant.dao.UserDao;
import team.market.merchant.dao.impl.UserDaoImpl;
import team.market.merchant.pojo.User;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserServiceImpl implements UserService{

    private UserDao userDao= new UserDaoImpl();

    @Override
    public User addUser(User user) {
        Map<String,String> condition = new HashMap<>();
        condition.put("username",user.getUsername());
        List<User> list = userDao.findByCondition(condition);
        if(list.size()==0){
            user.setId(UUIDUtils.getUUID());
            user.setStatus(User.NORMAL);
            user.setType(User.MERCHANT_USER);
            return  userDao.save(user);
        }
        else {
            return null;
        }

    }
}
