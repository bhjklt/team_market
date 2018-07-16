package team.market.merchant.servlet;

import team.market.common.auth.SecurityUtils;
import team.market.common.auth.pojo.Permission;
import team.market.common.auth.pojo.User;
import team.market.common.servlet.BaseServlet;
import team.market.common.util.API;
import team.market.common.util.HttpUtil;
import team.market.common.util.JsonUtil;
import team.market.merchant.pojo.StoreForm;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Burgess Li
 */
public class DashboardServlet extends BaseServlet {

    public String index(HttpServletRequest request, HttpServletResponse response) throws Exception {

        request.setAttribute("createStorePermission", SecurityUtils.getSubject().isPermitted(Permission.DefaultPermission.CREATE_STORE));

        Map<String, String> params = new HashMap<>();
        params.put("USER_ID", ((User)SecurityUtils.getSubject().getAuthorizingInfo()).getId());
        String storeFormJson  = HttpUtil.doPost(API.GET_STORE_FORM, params);


        System.err.println(storeFormJson);
        if (storeFormJson != null && !storeFormJson.isEmpty()) {
            StoreForm storeForm = JsonUtil.json2pojo(storeFormJson, StoreForm.class);
            request.setAttribute("storeForm", storeForm);
        }

        return "center.jsp";
    }

}
