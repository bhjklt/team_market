package team.market.administrator.service;

import team.market.administrator.dao.StoreDaoImpl;
import team.market.administrator.pojo.Store;
import team.market.administrator.pojo.StoreForm;
import team.market.administrator.pojo.StoreFormRecord;

public class StoreService {
    private StoreDaoImpl storeDao = new StoreDaoImpl();
    StoreFormRecordService storeFormRecordService = new StoreFormRecordService();

    public Store getStoreByUid(String uid) {
        StoreFormRecord storeFormRecord = storeFormRecordService.getStoreFormRecordByUid(uid);
        Store store = getStoreById(storeFormRecord.getsId());
        return store;
    }

    public Store getStoreById(String id){
        return storeDao.find(id);
    }

    public void saveStore(Store store){
        storeDao.save(store);
    }
}
