package team.market.merchant.util;



import team.market.common.util.UUIDUtils;
import team.market.common.util.ValidationUtil;
import team.market.merchant.pojo.Identity;
import team.market.merchant.pojo.Store;
import team.market.merchant.pojo.StoreForm;
import team.market.merchant.pojo.User;
import java.sql.Date;
import java.util.Map;

public class CovertParamsToBean {


    public StoreForm covertParamsToStFo(Map<String,Object> params){
        StoreForm storeForm=null;
        Identity identity=null;
        Store store=null;
        try{
            storeForm = new StoreForm();
            identity = new Identity();
            store = new Store();
            store.setAddress((String) params.get("Store.address"));
            store.setLicense((String)params.get("Store.license"));
            store.setName((String)params.get("Store.name"));
            store.setId(UUIDUtils.getUUID());
            store.setStatus(Store.AVAILABLE);
            identity.setName((String)params.get("Identity.name"));
            identity.setIdCardNumber((String)params.get("Identity.idCardNumber"));
            String Idcard = (String)params.get("Identity.idCardNumber");
            identity.setId(UUIDUtils.getUUID());
            identity.setStatus(Identity.NORMAL);
            storeForm.setStore(store);
            storeForm.setIdentity(identity);
            storeForm.setSubmitTime(new Date(System.currentTimeMillis()));
            storeForm.setUser((User)params.get("user"));

        }catch (Exception e){
            e.printStackTrace();
        }
        return storeForm;

    }

}
