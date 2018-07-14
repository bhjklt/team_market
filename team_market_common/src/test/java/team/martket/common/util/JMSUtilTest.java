package team.martket.common.util;

import org.junit.Test;
import team.market.common.util.JMSClient;

/**
 * @ Author     ：LILA3
 * @ Date       ：Created in 5:42 PM 7/14/2018
 */
public class JMSUtilTest {
    @Test
    public void testSend(){
        JMSClient jsclient = new JMSClient();
        jsclient.sendMessage("lance.queue", "aasacsac");
    }

    @Test
    public void testRec(){
        JMSClient jsclient = new JMSClient();
        System.out.println(jsclient.receiveMessage("lance.queue"));
    }
}
