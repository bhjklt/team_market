package team.market.customer.service.impl;

import team.market.customer.dao.StoreInformationDao;
import team.market.customer.dao.impl.StoreInformationDaoImpl;
import team.market.customer.pojo.StoreInformation;
import team.market.customer.service.StoreInformationService;

import java.util.List;
import java.util.Map;

public class StoreInformationServiceImpl implements StoreInformationService {

    private StoreInformationDao storeInformationDao = new StoreInformationDaoImpl();

    @Override
    public StoreInformation find(String s) {
        return null;
    }

    @Override
    public List<StoreInformation> findAll() {
        return null;
    }

    @Override
    public StoreInformation save(StoreInformation storeInformation) {
        return null;
    }

    @Override
    public boolean delete(String s) {
        return false;
    }

    @Override
    public List<StoreInformation> findByCondition(Map map) {
        return null;
    }

    @Override
    public boolean update(StoreInformation storeInformation) {
        return false;
    }

    @Override
    public List<StoreInformation> findStoreInformationsBySids(List<String> sids) {
        return storeInformationDao.findStoreInformationsBySids(sids);
    }


}
