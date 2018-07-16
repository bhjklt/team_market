package team.market.administrator.service;

import team.market.administrator.dao.AdFormDaoImpl;
import team.market.administrator.pojo.AdForm;
import team.market.administrator.pojo.AdStore;
import team.market.administrator.pojo.Store;
import team.market.administrator.pojo.User;

import java.sql.Date;
import java.util.*;

public class AdFormService {

    private AdFormDaoImpl adFromDao = new AdFormDaoImpl();

    public void saveAddForm(AdForm adForm) {
        AdForm af = adFromDao.save(adForm);
    }

    public List<AdForm> getAllAd(){
        List<AdForm> all = adFromDao.findAll();
        return all;
    }

    public void confirmAd(String id,String uid) {
        AdForm adForm = adFromDao.find(id);
        adForm.setConsumeTime(new Date(System.currentTimeMillis()));
        adForm.setConsumeUId(uid);
        adFromDao.update(adForm);
    }

    public List<AdStore> getConfirmAd() {
        List<AdForm> adForms = adFromDao.findByConWithSort(null, false, "CONSUME_TIME", 3);
        List<AdStore> adStores = new LinkedList<AdStore>();
        for(AdForm ad : adForms){
            Store store = new StoreService().getStoreById(ad.getsId());
            adStores.add(new AdStore(ad,store,null));
        }
        return adStores;
    }
}
