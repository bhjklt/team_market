package team.market.administrator.servlet;

import team.market.administrator.pojo.*;
import team.market.administrator.service.*;
import team.market.common.servlet.BaseServlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
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


    public String getAllAd(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        AdFormService adFormService = new AdFormService();
        StoreService storeService = new StoreService();
        AdminService adminService = new AdminService();
        List<AdStore> adStores = new ArrayList<AdStore>();
        List<AdForm> allAd = adFormService.getAllAd();
        for (AdForm ad : allAd){
            User user = adminService.getUser(ad.getConsumeUId());
            String sid = ad.getsId();
            Store store = storeService.getStoreById(sid);
            if(store != null && store.getStatus() == Store.AVAILABLE){
                AdStore adStore = new AdStore(ad,store,user);
                adStores.add(adStore);
            }
        }
        System.out.println(adStores);
        req.setAttribute("ads",adStores);
        return "/admin/ads.jsp";
    }


    public String confirmAd(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User admin = (User)req.getSession().getAttribute("admin");
        String id = req.getParameter("id");
        AdFormService adFormService = new AdFormService();
        adFormService.confirmAd(id,admin.getId());
        return getAllAd(req,resp);
    }
}
