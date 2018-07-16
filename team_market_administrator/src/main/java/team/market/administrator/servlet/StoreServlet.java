package team.market.administrator.servlet;

import team.market.administrator.pojo.Store;
import team.market.administrator.service.StoreService;
import team.market.common.servlet.BaseServlet;
import team.market.common.util.JsonUtil;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class StoreServlet extends BaseServlet {

    private static StoreService storeService = new StoreService();

    /**
     * 获取stroe信息
     * @param request
     * @param response
     * @throws Exception
     */
    public void available(HttpServletRequest request, HttpServletResponse response) throws Exception {

        response.setContentType("text/json");
        response.setCharacterEncoding("UTF-8");


        List<Store> storeList = storeService.getAvailableStores();

//        System.err.println(new String(JsonUtil.toJson(storeList).getBytes("ISO-8859-1"), "GBK"));
        response.getWriter().write(JsonUtil.obj2json(storeList));

    }

}
