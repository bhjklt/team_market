package team.market.administrator.listener;

import team.market.administrator.dao.StoreFormDaoImpl;
import team.market.administrator.pojo.StoreForm;
import team.market.administrator.service.StoreFormService;
import team.market.common.util.JsonUtil;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * @ Author     ：LILA3
 * @ Date       ：Created in 1:03 PM 7/15/2018
 */
public class StoreFormListener implements MessageListener {
    StoreFormService storeFormService = new StoreFormService();

    @Override
    public void onMessage(Message message) {
        try {
            String data = ((TextMessage) message).getText();
            System.out.println("receive storeform " + data);
            StoreForm storeForm = JsonUtil.json2pojo(data, StoreForm.class);
            storeFormService.saveStoreForm(storeForm);
            message.acknowledge();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
