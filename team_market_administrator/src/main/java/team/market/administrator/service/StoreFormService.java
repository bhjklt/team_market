package team.market.administrator.service;

import team.market.administrator.dao.StoreFormDaoImpl;
import team.market.administrator.pojo.StoreForm;
import team.market.common.util.JsonUtil;

/**
 * @ Author     ：LILA3
 * @ Date       ：Created in 1:12 PM 7/15/2018
 */
public class StoreFormService {
    StoreFormDaoImpl storeFormDao = new StoreFormDaoImpl();

    public void saveStoreForm(StoreForm storeForm) {
        try {
            storeFormDao.save(storeForm);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
