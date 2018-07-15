package team.market.merchant.util;


import team.market.merchant.pojo.Identity;
import team.market.merchant.pojo.Store;
import team.market.merchant.pojo.StoreForm;

import java.util.Map;

public class CovertParamsToBean {


    public StoreForm covertParamsToStFo(Map<String,String> params){
        StoreForm storeForm=null;
        Identity identity=null;
        Store store=null;
        try{
            storeForm = new StoreForm();
            identity = new Identity();
            store = new Store();
            store.setAddress(params.get("Store.address"));
            store.setLicense(params.get("Store.license"));
            store.setName(params.get("Store.name"));
            identity.setName(params.get("Identity.name"));
            identity.setIdCardNumber(params.get("Identity.idCardNumber"));
            identity.setIdCardPic(params.get("Identity.idCardPic"));
            storeForm.setStore(store);
            storeForm.setIdentity(identity);

        }catch (Exception e){
            e.printStackTrace();
        }
        return storeForm;

    }

}
