package team.market.merchant.servlet;

import team.market.merchant.pojo.User;
import team.market.common.servlet.BaseServlet;
import team.market.merchant.dao.UserDao;
import team.market.merchant.dao.impl.UserDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserServlet extends BaseServlet {

    private UserDao userDao = new UserDaoImpl();

    public void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       User user = null;
       User userData = userDao.findUser(user.getUsername());
       if(userData != null){
           if(userData.getPassword().equals(user.getPassword())){
               //跳转到主页
                resp.sendRedirect(req.getContextPath()+"/");
           }else{
               //密码错误
           }

       }else{
           //用户名错误
       }

    }

    public void register(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


    }
}
