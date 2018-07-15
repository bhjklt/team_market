package team.market.merchant.dao.impl;

import team.market.common.dao.BaseDaoImpl;
import team.market.common.pojo.User;
import team.market.common.util.ConnectionManager;
import team.market.common.util.ResultSetUtil;
import team.market.merchant.dao.UserDao;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;


public class UserDaoImpl extends BaseDaoImpl<User,Serializable> implements UserDao {
    @Override
    public User findUser(String username) {
        User user = null;
        String sql = "select password from User where username = "+ username;
        try {
            PreparedStatement statement = ConnectionManager.getInstance().prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            List<Map> list = ResultSetUtil.convertList(rs);
            if(list.size()>0){
                Map row = list.get(0);
                user.setUsername((String) row.get("password"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }
}
