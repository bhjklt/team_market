package team.market.administrator.servlet;

import team.market.administrator.service.StoreFormService;
import team.market.common.servlet.BaseServlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MApiServlet extends BaseServlet {


    public String check(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String user_id = req.getParameter("USER_ID");
        StoreFormService service = new StoreFormService();
        service.getStoreFormByUid(user_id);
        return null;
    }
}
