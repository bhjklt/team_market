package team.market.common.auth.listener;

import team.market.common.auth.SecurityUtils;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class SecurityRequestAndSessionListener implements ServletRequestListener, HttpSessionListener {

    @Override
    public void requestDestroyed(ServletRequestEvent sre) { }

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        SecurityUtils.addSubject();
    }

    @Override
    public void sessionCreated(HttpSessionEvent se) { }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        SecurityUtils.removeSubject(se.getSession());
    }

}
