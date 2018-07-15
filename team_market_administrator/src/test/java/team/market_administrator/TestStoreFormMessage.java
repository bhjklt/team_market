package team.market_administrator;

import org.junit.Test;
import team.market.administrator.pojo.*;
import team.market.common.util.JmsReceiver;
import team.market.common.util.JmsSender;
import team.market.common.util.JsonUtil;

import java.util.Date;

/**
 * @ Author     ：LILA3
 * @ Date       ：Created in 1:17 PM 7/15/2018
 */
public class TestStoreFormMessage {
    @Test
    public void testSendStoreForm() {

        User user = new User();
        user.setId("asddsadd");
        user.setCreateTime(new Date());
        StoreFormRecord storeFormRecord = new StoreFormRecord();
        storeFormRecord.setId("saddasdsad");
        Store store = new Store();
        store.setId("asdsdsad");
        Identity identity = new Identity();
        identity.setName("addadasddd");

        StoreForm storeForm = new StoreForm();
        storeForm.setUser(user);
        storeForm.setStore(store);

        JmsSender jmsSender = new JmsSender();
        try {
            String data = "{\n" +
                    "    \"user\":{\n" +
                    "        \"id\":\"9df2e61c91384184818cc001b175ac44\",\n" +
                    "        \"identityId\":null,\n" +
                    "        \"username\":null,\n" +
                    "        \"password\":null,\n" +
                    "        \"type\":null,\n" +
                    "        \"status\":null,\n" +
                    "        \"createTime\":null,\n" +
                    "        \"permissions\":null\n" +
                    "    },\n" +
                    "    \"identity\":{\n" +
                    "        \"id\":\"ed5834a5fc14410d8ce097fc8c86d850\",\n" +
                    "        \"name\":\"qeqwe\",\n" +
                    "        \"idCardNumber\":\"123456\",\n" +
                    "        \"idCardPic\":\"f679011ficonf.png\",\n" +
                    "        \"status\":0\n" +
                    "    },\n" +
                    "    \"store\":{\n" +
                    "        \"id\":\"22152f9d3b7f461badf1d16347a355bb\",\n" +
                    "        \"name\":\"1111\",\n" +
                    "        \"address\":\"1111\",\n" +
                    "        \"license\":\"1111\",\n" +
                    "        \"status\":0\n" +
                    "    },\n" +
                    "    \"submitTime\":1531634954398\n" +
                    "}";

            System.out.println(data);
            jmsSender.sendMessage("lance.queue",data);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testReceiveStoreForm() {
        JmsReceiver jmsReceiver = new JmsReceiver();
        String data = jmsReceiver.receiveMessage("lance.queue");
        System.out.println(data);
        try {
            StoreForm storeForm = JsonUtil.json2pojo(data,StoreForm.class);
            System.out.println();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
