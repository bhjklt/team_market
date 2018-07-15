package team.market.common.util;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;

import javax.jms.*;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @ Author     ：LILA3
 * @ Date       ：Created in 11:26 AM 7/15/2018
 */
public class JmsSender {
    ConnectionFactory connectionFactory;
    Connection connection = null;
    Session session;
    String url = "tcp://10.222.29.157:61616";
    String queueName = "lance.queue";
    Map<String, MessageProducer> sendQueues = new ConcurrentHashMap<String, MessageProducer>();

    public JmsSender() {
        ConnectionFactory factory = new ActiveMQConnectionFactory(url);
        Connection con = null;
        try {
            con = factory.createConnection();
            con.start();
            session = con.createSession(false, Session.CLIENT_ACKNOWLEDGE);
        } catch (JMSException e) {
            e.printStackTrace();
        }

    }

    public void sendMessage(String queueName, String data) {
        try {
            MessageProducer messageProducer = null;
            if (sendQueues.containsKey(queueName)) {
                messageProducer = sendQueues.get(queueName);
                System.out.println("send msg = " + data);
            } else {
                Destination queue = new ActiveMQQueue(queueName);
                messageProducer = session.createProducer(queue);
                sendQueues.put(queueName, messageProducer);
            }
            messageProducer.send(session.createTextMessage(data));
        } catch (JMSException e) {
            e.printStackTrace();
        }

    }

}
