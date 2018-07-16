package team.market.administrator.service;

import team.market.administrator.dao.StoreDaoImpl;
import team.market.administrator.dao.StoreFormDaoImpl;
import team.market.administrator.dao.StoreFormRecordDaoImpl;
import team.market.administrator.pojo.Store;
import team.market.administrator.pojo.StoreForm;
import team.market.administrator.pojo.StoreFormRecord;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StoreService {
    private StoreDaoImpl storeDao = new StoreDaoImpl();
    StoreFormRecordService storeFormRecordService = new StoreFormRecordService();
    StoreFormRecordDaoImpl storeFormRecordDao = new StoreFormRecordDaoImpl();

    public Store getStoreByUid(String uid) {
        StoreFormRecord storeFormRecord = storeFormRecordService.getStoreFormRecordByUid(uid);
        Store store = getStoreById(storeFormRecord.getsId());
        return store;
    }

    public Store getStoreById(String id) {
        return storeDao.find(id);
    }

    public List<Store> getAvailableStores() {
        List<Store> stores = new ArrayList<Store>();

        Map<String, String> conditions = new HashMap<String, String>();
        conditions.put("status", StoreFormRecord.ACCEPT.toString());
        List<StoreFormRecord> storeFormRecords = storeFormRecordDao.findByCondition(conditions);

        for (StoreFormRecord storeFormRecord : storeFormRecords) {
            conditions.clear();
            conditions.put("id", storeFormRecord.getsId());
            conditions.put("status", Store.AVAILABLE.toString());
            stores.addAll(storeDao.findByCondition(conditions));
        }

        return stores;
    }

    public void saveStore(Store store) {
        storeDao.save(store);
    }
}
