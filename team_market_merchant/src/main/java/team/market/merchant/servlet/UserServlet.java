package team.market.merchant.servlet;

import team.market.common.auth.SecurityUtils;
import team.market.common.auth.Subject;
import team.market.common.auth.UsernamePasswordToken;
import team.market.common.auth.exception.UnknownAccountException;
import team.market.common.auth.pojo.Permission;
import team.market.common.util.Md5Utils;
import team.market.merchant.pojo.User;
import team.market.common.servlet.BaseServlet;
import team.market.merchant.dao.UserDao;
import team.market.merchant.dao.impl.UserDaoImpl;
import team.market.merchant.service.UserService;
import team.market.merchant.service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserServlet extends BaseServlet {

    private UserService userService = new UserServiceImpl();

    private static final String PARAMS_NULL_ERROR = "用户名或密码不能为空";
    private static final String USER_NULL_ERROR = "用户名或密码错误";
    private static final String USER_MORE_ERROR = "用户名已存在";
    private static final String INDEX_HTML = "login.jsp";
    private static final String CENTER_HTML = "/dashboard?method=index";
    private static final String REGISITER_HTML = "register.jsp";

    public String login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Subject subject = SecurityUtils.getSubject();
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String result = INDEX_HTML;
        if(username!=null&&password!=null){
            try {
                subject.login(new UsernamePasswordToken(username,Md5Utils.md5Password(password)));
                if(subject.isLogged()){
                    req.removeAttribute("login.jsp");
                    result = CENTER_HTML;
                }
            }
            catch (UnknownAccountException uk){
                req.setAttribute("login_error",USER_NULL_ERROR);
                return result;
            }
        }
        else {
            req.setAttribute("login_error",PARAMS_NULL_ERROR);
        }
        return result;



    }

    public String register(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String result = REGISITER_HTML;
        if(username!=null&&password!=null){
            User newUser = new User();
            newUser.setUsername(username);
            newUser.setPassword(password);
            User user = userService.addUser(newUser);
            if(user!=null){
                Subject subject = SecurityUtils.getSubject();
                subject.login(new UsernamePasswordToken(username,Md5Utils.md5Password(password)));
                subject.addPermission(Permission.DefaultPermission.CREATE_STORE);
                result = CENTER_HTML;
            }
            else {
                req.setAttribute("register_error",USER_MORE_ERROR);
            }
        }
        else {
            req.setAttribute("register_error",PARAMS_NULL_ERROR);
        }
        return result;

    }

    public String logout(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        SecurityUtils.getSubject().logout();

        return "/login.jsp";
    }

}
