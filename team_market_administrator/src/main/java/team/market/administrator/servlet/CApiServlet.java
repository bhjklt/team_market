package team.market.administrator.servlet;

import team.market.administrator.pojo.AdStore;
import team.market.administrator.service.AdFormService;
import team.market.common.servlet.BaseServlet;
import team.market.common.util.JsonUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class CApiServlet extends BaseServlet {
    AdFormService adFormService = new AdFormService();

    /**
     * 获取广告信息
     *
     * @param req
     * @param resp
     * @throws Exception
     */
    public void getAd(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        List<AdStore> confirmAd = adFormService.getConfirmAd();
        String json = JsonUtil.obj2json(confirmAd);
        resp.getWriter().write(json);
    }
}
