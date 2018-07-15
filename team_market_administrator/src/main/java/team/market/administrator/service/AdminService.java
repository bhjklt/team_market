package team.market.administrator.service;

import team.market.administrator.dao.UserDaoImpl;
import team.market.administrator.pojo.User;
import team.market.common.dao.BaseDao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AdminService {

    private BaseDao userDao = new UserDaoImpl();

    public boolean login(User admin) {
        boolean isLogin = false;
        Map<String,String> map = new HashMap<String,String>();
        map.put("username",admin.getUsername());
        List users = userDao.findByCondition(map);
        if(users != null && users.size() == 1){
            User user = (User) users.get(0);
            if(user.getPassword().equals(admin.getPassword())){
                isLogin = true;
            }
        }
        return isLogin;
    }
}
