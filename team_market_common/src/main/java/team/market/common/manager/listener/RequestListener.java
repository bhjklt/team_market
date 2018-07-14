package team.market.common.manager.listener;

import team.market.common.manager.ContextManager;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpServletRequest;

public class RequestListener implements ServletRequestListener {

    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        ContextManager.getInstance().removeSession();
    }

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        ContextManager.getInstance().addSession(((HttpServletRequest)sre.getServletRequest()).getSession(true));
    }

}
