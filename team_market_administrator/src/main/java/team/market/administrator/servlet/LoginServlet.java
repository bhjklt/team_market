package team.market.administrator.servlet;

import team.market.administrator.pojo.User;
import team.market.administrator.service.AdminService;
import team.market.common.annontation.RequiresPermission;
import team.market.common.auth.SecurityUtils;
import team.market.common.auth.Subject;
import team.market.common.manager.ContextManager;
import team.market.common.servlet.BaseServlet;
import team.market.common.util.WebUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginServlet extends BaseServlet {

    public String login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        AdminService service = new AdminService();
        User admin = new User();
        try {
            admin = (User)WebUtil.parseRequest(admin, req.getParameterMap(), User.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        boolean isLogin = service.login(admin);
        if(!isLogin){
            req.setAttribute("errorMsg","用户名或密码错误");
            return "/adminLogin.jsp";
        }
        HttpSession session = req.getSession();
        session.setAttribute("admin",admin);
        return "r:/admin/index.jsp";
    }

    public String logout(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        session.setAttribute("admin",null);
        return "r:/adminLogin.jsp";
    }

}
