package team.market.merchant.servlet;

import team.market.common.auth.SecurityUtils;
import team.market.common.auth.pojo.User;
import team.market.common.servlet.BaseServlet;
import team.market.common.util.*;
import team.market.merchant.pojo.AdForm;
import team.market.merchant.pojo.StoreForm;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Burgess Li
 */
public class AdFormServlet extends BaseServlet {

    public String add(HttpServletRequest request, HttpServletResponse response) throws Exception {

        AdForm adForm = (AdForm) WebUtil.parseRequest(new AdForm(), request.getParameterMap(), AdForm.class);

        Map<String, String> params = new HashMap<>();
        params.put("USER_ID", ((User)SecurityUtils.getSubject().getAuthorizingInfo()).getId());
        String storeFormJson  = HttpUtil.doPost(API.GET_STORE_FORM, params);

        if (storeFormJson != null && !storeFormJson.isEmpty()) {
            StoreForm storeForm = JsonUtil.json2pojo(storeFormJson, StoreForm.class);
            adForm.setsId(storeForm.getStore().getId());
            JmsSender jmsSender = new JmsSender();
            jmsSender.sendMessage("ad.queue",JsonUtil.obj2json(adForm));
        }

        return "/dashboard?method=index";
    }

}
