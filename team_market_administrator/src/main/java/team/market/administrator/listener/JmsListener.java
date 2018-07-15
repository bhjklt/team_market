package team.market.administrator.listener;

import team.market.common.util.JmsReceiver;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @ Author     ：LILA3
 * @ Date       ：Created in 11:32 AM 7/15/2018
 */
public class JmsListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        JmsReceiver jmsReceiver = new JmsReceiver();
        jmsReceiver.receiveMessage(new StromFromListener(), "lance.queue");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }

    class StromFromListener implements MessageListener {

        @Override
        public void onMessage(Message message) {
            try {
                System.out.println(((TextMessage) message).getText());
            } catch (JMSException e) {
                e.printStackTrace();
            }
        }
    }
}
