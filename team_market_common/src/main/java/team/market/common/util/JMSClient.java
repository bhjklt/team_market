package team.market.common.util;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.apache.camel.Producer;

import javax.jms.*;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @ Author     ：LILA3
 * @ Date       ：Created in 4:28 PM 7/14/2018
 */
public class JMSClient {
    ConnectionFactory connectionFactory;
    Connection connection = null;
    Session session;
    String url = "tcp://10.222.29.196:61616";
    String queueName = "lance.queue";
    Map<String, MessageProducer> sendQueues = new ConcurrentHashMap<String, MessageProducer>();
    Map<String, MessageConsumer> receiveQueues = new ConcurrentHashMap<String, MessageConsumer>();

    public JMSClient() {
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

    public String receiveMessage(String queueName) {
        try {
            MessageConsumer messageConsumer = null;
            if (sendQueues.containsKey(queueName)) {
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

    public void close() {
        try {
            connection.close();
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }

}
