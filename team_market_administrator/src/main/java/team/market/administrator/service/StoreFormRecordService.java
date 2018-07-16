package team.market.administrator.service;

import team.market.administrator.dao.IdentityDaoImpl;
import team.market.administrator.dao.StoreDaoImpl;
import team.market.administrator.dao.StoreFormDaoImpl;
import team.market.administrator.dao.StoreFormRecordDaoImpl;
import team.market.administrator.pojo.StoreForm;
import team.market.administrator.pojo.StoreFormRecord;
import team.market.common.dao.BaseDao;
import team.market.common.util.JsonUtil;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

/**
 * @ Author     ：LILA3
 * @ Date       ：Created in 1:12 PM 7/15/2018
 */
public class StoreFormRecordService {

    private BaseDao stroeRecordDao = new StoreFormRecordDaoImpl();

    public StoreFormRecord getStoreFormRecordByUid(String user_id) {
        HashMap<String, String> params = new HashMap<String, String>();
        params.put("USER_ID", user_id);
        List<StoreFormRecord> rs = stroeRecordDao.findByConWithSort(params, false, "CREATE_TIME", null);
        if(rs.size() > 0){
            return rs.get(0);
        }else{
            return null;
        }
//        List storeRecords = stroeRecordDao.findByCondition(params);
//        if (storeRecords != null && storeRecords.size() > 0) {
//            Collections.sort(storeRecords, new Comparator<StoreFormRecord>() {
//                @Override
//                public int compare(StoreFormRecord o1, StoreFormRecord o2) {
//                    return o1.getCreateTime().compareTo(o2.getCreateTime());
//                }
//            });
//            StoreFormRecord sr = (StoreFormRecord) storeRecords.get(0);
//            return sr;
//        }
    }

    public StoreFormRecord getStoreFormRecordById(String id) {
        HashMap<String, String> params = new HashMap<String, String>();
        return (StoreFormRecord) stroeRecordDao.find(id);
    }


    public void updateStatus(String id, String status) {
        HashMap<String, String> params = new HashMap<String, String>();
        StoreFormRecord storeFormRecord =  (StoreFormRecord) stroeRecordDao.find(id);
        storeFormRecord.setStatus(Integer.valueOf(status));
        stroeRecordDao.update(storeFormRecord);
    }



    public List<StoreFormRecord>getStoreFormRecord() {

        List storeRecords = stroeRecordDao.findAll();
        if (storeRecords != null && storeRecords.size() > 0) {
            Collections.sort(storeRecords, new Comparator<StoreFormRecord>() {
                @Override
                public int compare(StoreFormRecord o1, StoreFormRecord o2) {
                    return o1.getCreateTime().compareTo(o2.getCreateTime());
                }
            });
            return storeRecords;
        }
        return null;
    }



    public void saveStoreForm(StoreFormRecord storeFormRecord) {
        try {
            stroeRecordDao.save(storeFormRecord);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
