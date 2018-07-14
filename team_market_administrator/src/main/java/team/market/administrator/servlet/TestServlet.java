package team.market.administrator.servlet;

import team.market.common.auth.SecurityUtils;
import team.market.common.auth.Subject;
import team.market.common.auth.UsernamePasswordToken;
import team.market.common.auth.pojo.Permission;
import team.market.common.manager.ContextManager;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class TestServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Subject subject = SecurityUtils.getSubject();
        subject.login(new UsernamePasswordToken("test_user", "123456"));
        subject.checkPermission(new Permission("user:create"));

        resp.getWriter().write("Administrator");
    }

}
