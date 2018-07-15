package team.market.administrator.service;

import team.market.administrator.dao.IdentityDaoImpl;
import team.market.administrator.dao.StoreDaoImpl;
import team.market.administrator.dao.StoreFormRecordDaoImpl;
import team.market.administrator.pojo.Identity;
import team.market.administrator.pojo.Store;
import team.market.administrator.pojo.StoreForm;
import team.market.administrator.pojo.StoreFormRecord;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StoreFormService {
    StoreFormRecordDaoImpl storeFormRecordDao = new StoreFormRecordDaoImpl();
    StoreDaoImpl storeDao = new StoreDaoImpl();
    IdentityDaoImpl identityDao = new IdentityDaoImpl();

    public List<StoreForm> getStoreForms() {
        List<StoreFormRecord> list = storeFormRecordDao.findAll();
        List<StoreForm> storeForms = new ArrayList<StoreForm>();
        for (StoreFormRecord storeFormRecord : list) {
            String sid = storeFormRecord.getsId();
            String uid = storeFormRecord.getUserId();
            Map<String, String> map = new HashMap<String, String>();
            map.put("user_id", uid);

            Store store = storeDao.find(sid);
            List<Identity> identitys = identityDao.findByCondition(map);
            StoreForm storeForm = new StoreForm();
            if (identitys.size() > 0) {
                storeForm.setIdentity(identitys.get(0));
            }
            storeForm.setStore(store);

            storeForms.add(storeForm);
        }
        return storeForms;
    }

    public StoreForm getStoreForm(String user_id) {
        Map<String, String> map = new HashMap<String, String>();
        map.put("user_id", user_id);

        List<StoreFormRecord> storeFormRecords = storeFormRecordDao.findByCondition(map);
        if (storeFormRecords.size() > 0) {

            Store store = storeDao.find(storeFormRecords.get(0).getsId());
            StoreForm storeForm = new StoreForm();

            List<Identity> identitys = identityDao.findByCondition(map);
            if (identitys.size() > 0) {
                storeForm.setIdentity(identitys.get(0));
            }

            storeForm.setStore(store);
            return storeForm;
        }
        return null;
    }

}
