package team.market.common.auth.listener;

import team.market.common.auth.JDBCRealm;
import team.market.common.auth.Realm;
import team.market.common.auth.SecurityManager;
import team.market.common.auth.SecurityUtils;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.HashSet;
import java.util.Set;

public class SecurityContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        Set<Realm> realms = new HashSet<Realm>();
        realms.add(new JDBCRealm());
        SecurityUtils.initializeSecurityUtils(new SecurityManager(realms));
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }

}
