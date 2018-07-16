package team.market.administrator.servlet;

import team.market.administrator.pojo.User;
import team.market.administrator.service.AdminService;
import team.market.common.annontation.RequiresPermission;
import team.market.common.auth.SecurityUtils;
import team.market.common.auth.Subject;
import team.market.common.manager.ContextManager;
import team.market.common.servlet.BaseServlet;
import team.market.common.util.Md5Utils;
import team.market.common.util.WebUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginServlet extends BaseServlet {
    AdminService service = new AdminService();

    public String login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User admin = new User();
        try {
            admin = (User) WebUtil.parseRequest(admin, req.getParameterMap(), User.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        admin.setPassword(Md5Utils.md5Password(admin.getPassword()));
        if (admin.getUsername() == null || admin.getPassword() == null || "".equals(admin.getUsername().trim()) || "".equals(admin.getPassword().trim())) {
            req.setAttribute("errorMsg", "用户名或密码为空");
            return "/adminLogin.jsp";
        }
        User adminUser = service.login(admin);
        if (adminUser == null) {
            req.setAttribute("errorMsg", "用户名或密码错误");
            return "/adminLogin.jsp";
        }
        HttpSession session = req.getSession();
        session.setAttribute("admin", adminUser);
        return "r:/admin/index.jsp";
    }

    public String logout(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        session.setAttribute("admin", null);
        return "r:/adminLogin.jsp";
    }

}
