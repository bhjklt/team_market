package team.market.administrator.service;

import team.market.administrator.dao.AdFormDaoImpl;
import team.market.administrator.pojo.AdForm;

public class AdFromService {

    private AdFormDaoImpl adFromDao = new AdFormDaoImpl();

    public void saveAddForm(AdForm adForm) {
        AdForm af = adFromDao.save(adForm);
    }
}
