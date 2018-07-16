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
//        List<AdStore> adStores = new ArrayList<AdStore>();
//        List<AdForm> allAd = getAllAd();
//        for (AdForm ad : allAd){
//            if(ad.getConsumeTime() != null && !"".equals(ad.getConsumeTime()) && ad.getConsumeUId() != null){
//                Store store = new StoreService().getStoreById(ad.getsId());
//                adStores.add(new AdStore(ad,store,null));
//            }
//        }
//        Collections.sort(adStores, new Comparator<AdStore>() {
//            @Override
//            public int compare(AdStore o1, AdStore o2) {
//                return o1.getAdForm().getConsumeTime().getTime() >= o2.getAdForm().getConsumeTime().getTime() ? -1 : 1;
//            }
//        });
//        List<AdStore> result = new LinkedList<AdStore>();
//        for (int i = 0; i < 3; i++){
//            if(adStores.size() > i){
//                result.add(adStores.get(i));
//                System.out.println(adStores.get(i).getAdForm().getConsumeTime());
//            }
//        }
//        return result;

    }
}
