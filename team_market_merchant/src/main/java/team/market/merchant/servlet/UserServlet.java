package team.market.merchant.servlet;

import team.market.common.auth.SecurityUtils;
import team.market.common.auth.Subject;
import team.market.common.auth.UsernamePasswordToken;
import team.market.common.auth.exception.UnknownAccountException;
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

    private static final String PARAMS_NULL_ERROR = "用户名或密码不能为空";
    private static final String USER_NULL_ERROR = "用户名或密码错误";
    private static final String INDEX_HTML = "index.jsp";
    private static final String CENTER_HTML = "center.jsp";


    public String login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Subject subject = SecurityUtils.getSubject();
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String result = INDEX_HTML;
        if(username!=null&&password!=null){
            try {
                subject.login(new UsernamePasswordToken(username,password));
                if(subject.isLogged()){
                    req.removeAttribute("index.jsp");
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

    public void register(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


    }
}
