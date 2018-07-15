package team.martket.common.util;

import org.junit.Test;
import team.market.common.util.JMSClient;
import team.market.common.util.JmsReceiver;
import team.market.common.util.JmsSender;

/**
 * @ Author     ：LILA3
 * @ Date       ：Created in 5:42 PM 7/14/2018
 */
public class JMSUtilTest {
    @Test
    public void testSend(){
        JmsSender jmsSender = new JmsSender();
        jmsSender.sendMessage("lance.queue", "aasacsac");
    }

    @Test
    public void testRec(){
        JmsReceiver jmsReceiver = new JmsReceiver();
        System.out.println(jmsReceiver.receiveMessage("lance.queue"));
    }
}
