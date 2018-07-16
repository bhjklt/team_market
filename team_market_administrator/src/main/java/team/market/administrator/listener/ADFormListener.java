package team.market.administrator.listener;

import team.market.administrator.pojo.AdForm;
import team.market.administrator.service.AdFormService;
import team.market.common.util.JsonUtil;
import team.market.common.util.UUIDUtils;

import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

public class ADFormListener implements MessageListener {
    AdFormService adService = new AdFormService();
    @Override
    public void onMessage(Message message) {
        try {
            String msg = ((TextMessage) message).getText();
            AdForm adForm = JsonUtil.json2pojo(msg, AdForm.class);
            adForm.setId(UUIDUtils.getUUID());
            adService.saveAddForm(adForm);
            message.acknowledge();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
