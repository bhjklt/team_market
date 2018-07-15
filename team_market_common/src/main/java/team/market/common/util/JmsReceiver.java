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
public class JmsReceiver {
    ConnectionFactory connectionFactory;
    Connection connection = null;
    Session session;
    String url = "tcp://10.222.29.157:61616";
    String queueName = "lance.queue";
    Map<String, MessageConsumer> receiveQueues = new ConcurrentHashMap<String, MessageConsumer>();

    public JmsReceiver() {
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

    public String receiveMessage(String queueName) {
        try {
            MessageConsumer messageConsumer = null;
            if (receiveQueues.containsKey(queueName)) {
                messageConsumer = receiveQueues.get(queueName);
            } else {
                Destination queue = new ActiveMQQueue(queueName);
                messageConsumer = session.createConsumer(queue);
                receiveQueues.put(queueName, messageConsumer);
            }
            TextMessage data = (TextMessage) messageConsumer.receive();
            return data.getText();
        } catch (JMSException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void receiveMessage(MessageListener listener, String queueName) {
        try {
            MessageConsumer messageConsumer = null;
            if (receiveQueues.containsKey(queueName)) {
                messageConsumer = receiveQueues.get(queueName);
            } else {
                Destination queue = new ActiveMQQueue(queueName);
                messageConsumer = session.createConsumer(queue);
                receiveQueues.put(queueName, messageConsumer);
            }
            messageConsumer.setMessageListener(listener);
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }

    public void close() {
        try {
            connection.close();
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
