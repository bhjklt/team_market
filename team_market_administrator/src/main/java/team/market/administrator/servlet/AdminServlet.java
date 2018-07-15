package team.market.administrator.servlet;

import team.market.administrator.pojo.StoreForm;
import team.market.administrator.pojo.StoreFormRecord;
import team.market.administrator.service.StoreFormRecordService;
import team.market.administrator.service.StoreFormService;
import team.market.common.servlet.BaseServlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class AdminServlet extends BaseServlet {


    public String storeRecords(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        StoreFormService storeFormService = new StoreFormService();
        List<StoreForm> records = storeFormService.getStoreForms();
        req.setAttribute("records",records);
        return "/admin/records.jsp";
    }

    public String modifyStatus(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String srid = req.getParameter("id");
        String status = req.getParameter("status");
        StoreFormRecordService recordService = new StoreFormRecordService();
         recordService.updateStatus(srid, status);
        return storeRecords(req, resp);
    }
}
