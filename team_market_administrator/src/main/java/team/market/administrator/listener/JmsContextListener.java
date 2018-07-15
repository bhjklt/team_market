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
public class JmsContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        JmsReceiver jmsReceiver = new JmsReceiver();
        jmsReceiver.receiveMessage(new StoreFormListener(), "lance.queue");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
