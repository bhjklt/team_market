package team.market.administrator.listener;

import team.market.administrator.pojo.Identity;
import team.market.administrator.pojo.Store;
import team.market.administrator.pojo.StoreForm;
import team.market.administrator.pojo.StoreFormRecord;
import team.market.administrator.service.IdentityService;
import team.market.administrator.service.StoreFormRecordService;
import team.market.administrator.service.StoreService;
import team.market.common.util.JsonUtil;
import team.market.common.util.UUIDUtils;

import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import java.sql.Date;

/**
 * @ Author     ：LILA3
 * @ Date       ：Created in 1:03 PM 7/15/2018
 */
public class StoreFormListener implements MessageListener {
    StoreFormRecordService storeFormService = new StoreFormRecordService();
    StoreService storeService = new StoreService();
    IdentityService identityService = new IdentityService();

    @Override
    public void onMessage(Message message) {
        try {
            String data = ((TextMessage) message).getText();

            System.out.println("receive storeform " + data);
            StoreForm storeForm = JsonUtil.json2pojo(data, StoreForm.class);



            Identity identity = storeForm.getIdentity();
            identityService.saveIdentity(identity);

            Store store = storeForm.getStore();
            store.setId(UUIDUtils.getUUID());

            StoreFormRecord storeFormRecord = new StoreFormRecord();
            storeFormRecord.setId(UUIDUtils.getUUID());
            storeFormRecord.setsId(store.getId());
            storeFormRecord.setStatus(StoreFormRecord.PENDING);
            storeFormRecord.setUserId(storeForm.getUser().getId());
            storeFormRecord.setCreateTime(new Date(System.currentTimeMillis()));
            storeFormService.saveStoreForm(storeFormRecord);
            storeService.saveStore(store);
            Thread.sleep(3000);
            message.acknowledge();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
