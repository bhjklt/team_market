package team.market.administrator.servlet;

import team.market.administrator.pojo.Identity;
import team.market.administrator.pojo.Store;
import team.market.administrator.pojo.StoreForm;
import team.market.administrator.service.IdentityService;
import team.market.administrator.service.StoreFormRecordService;
import team.market.administrator.service.StoreFormService;
import team.market.administrator.service.StoreService;
import team.market.common.servlet.BaseServlet;
import team.market.common.util.JsonUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MApiServlet extends BaseServlet {

    IdentityService identityService = new IdentityService();
    StoreService storeService = new StoreService();
    StoreFormRecordService storeFormRecordService = new StoreFormRecordService();
    StoreFormService storeFormService = new StoreFormService();

    /**
     * 获取状态
     *
     * @param req
     * @param resp
     * @throws Exception
     */
    public void check(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        String user_id = req.getParameter("USER_ID");
        StoreFormRecordService service = new StoreFormRecordService();
        resp.getWriter().write(JsonUtil.obj2json(service.getStoreFormRecordByUid(user_id)));
    }

    /**
     * 获取商铺信息
     *
     * @param req
     * @param resp
     * @throws Exception
     */
    public void getStore(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        String user_id = req.getParameter("USER_ID");
        Store store = storeService.getStoreByUid(user_id);
        resp.getWriter().write(JsonUtil.obj2json(store));
    }

    /**
     * 获取商家信息
     *
     * @param req
     * @param resp
     * @throws Exception
     */
    public void getIndentity(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        String identity_id = req.getParameter("IDENTITY_ID");
        Identity identity = identityService.getIdentity(identity_id);
        resp.getWriter().write(JsonUtil.obj2json(identity));
    }

    /**
     *
     * @param req
     * @param resp
     * @throws Exception
     */
    public void getStoreForm(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        String user_id = req.getParameter("USER_ID");
        StoreForm storeForm = storeFormService.getStoreForm(user_id);
        resp.getWriter().write(JsonUtil.obj2json(storeForm));
    }


}
