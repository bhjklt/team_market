package team.market.merchant.servlet;

import team.market.common.auth.SecurityUtils;
import team.market.common.auth.pojo.User;
import team.market.common.servlet.BaseServlet;
import team.market.common.util.HttpUtil;
import team.market.common.util.JmsSender;
import team.market.common.util.JsonUtil;
import team.market.common.util.WebUtil;
import team.market.merchant.pojo.AdForm;
import team.market.merchant.pojo.StoreForm;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

public class AdFormServlet extends BaseServlet {

    private static final String API = "http://10.222.29.195:9090/m/api?method=getStoreForm";

    public String add(HttpServletRequest request, HttpServletResponse response) throws Exception {

        AdForm adForm = (AdForm) WebUtil.parseRequest(new AdForm(), request.getParameterMap(), AdForm.class);

        Map<String, String> params = new HashMap<>();
        params.put("USER_ID", ((User)SecurityUtils.getSubject().getAuthorizingInfo()).getId());
        String storeFormJson  = HttpUtil.doPost(API, params);

        if (storeFormJson != null && !storeFormJson.isEmpty()) {
            StoreForm storeForm = JsonUtil.json2pojo(storeFormJson, StoreForm.class);
            adForm.setsId(storeForm.getStore().getId());
            JmsSender jmsSender = new JmsSender();
            jmsSender.sendMessage("ad.queue",JsonUtil.obj2json(adForm));
        }

        return "/dashboard?method=index";
    }

}
