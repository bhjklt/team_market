package team.market.merchant.service;

import team.market.merchant.dao.impl.AdFormDaoImpl;
import team.market.merchant.pojo.AdForm;

import java.util.List;
import java.util.Map;

public class AdFormServiceImpl implements AdFormService {

    private static AdFormDaoImpl adFormDao = new AdFormDaoImpl();


    @Override
    public AdForm find(String s) {
        return adFormDao.find(s);
    }

    @Override
    public List<AdForm> findAll() {
        return adFormDao.findAll();
    }

    @Override
    public AdForm save(AdForm adForm) {
        return adFormDao.save(adForm);
    }

    @Override
    public boolean delete(String s) {
        return adFormDao.delete(s);
    }

    @Override
    public List<AdForm> findByCondition(Map map) {
        return adFormDao.findByCondition(map);
    }

    @Override
    public boolean update(AdForm adForm) {
        return adFormDao.update(adForm);
    }

}
