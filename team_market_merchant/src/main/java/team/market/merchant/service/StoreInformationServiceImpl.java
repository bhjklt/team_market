package team.market.merchant.service;

import team.market.common.util.UUIDUtils;
import team.market.merchant.dao.impl.StoreInformationDaoImpl;
import team.market.merchant.pojo.StoreInformation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Burgess Li
 */
public class StoreInformationServiceImpl implements StoreInformationService {

    private static StoreInformationDaoImpl storeInformationDao = new StoreInformationDaoImpl();

    @Override
    public StoreInformation find(String s) {
        return storeInformationDao.find(s);
    }

    @Override
    public List<StoreInformation> findAll() {
        return storeInformationDao.findAll();
    }

    @Override
    public StoreInformation save(StoreInformation storeInformation) {
        storeInformation.setId(UUIDUtils.getUUID());
        return storeInformationDao.save(storeInformation);
    }

    @Override
    public boolean delete(String s) {
        return storeInformationDao.delete(s);
    }

    @Override
    public List<StoreInformation> findByCondition(Map map) {
        return storeInformationDao.findByCondition(map);
    }

    @Override
    public boolean update(StoreInformation storeInformation) {
        return storeInformationDao.update(storeInformation);
    }

    public StoreInformation findBySId(String sId) {
        Map<String, String> conditions = new HashMap<>();
        conditions.put("sid", sId);
        List<StoreInformation> storeInformations = storeInformationDao.findByCondition(conditions);
        if (storeInformations.size() > 0)
            return storeInformations.get(0);
        return null;
    }

}
