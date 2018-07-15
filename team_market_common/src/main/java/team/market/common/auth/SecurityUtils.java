package team.market.common.auth;

import team.market.common.manager.ContextManager;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionListener;
import java.util.concurrent.ConcurrentHashMap;

public final class SecurityUtils {

    private static SecurityManager securityManager;
    private static ConcurrentHashMap<String, Subject> subjectConcurrentHashMap = null;

    private SecurityUtils(SecurityManager manager) {
        securityManager = manager;
    }

    public static void initializeSecurityUtils(SecurityManager manager) {
        System.out.println("initialize security utils");
        securityManager = manager;
        subjectConcurrentHashMap = new ConcurrentHashMap<String, Subject>();
    }

    public static SecurityManager getSecurityManager() {
        return securityManager;
    }

    public static void addSubject() {
        if (!subjectConcurrentHashMap.containsKey(ContextManager.getInstance().getSession().getId()))
            subjectConcurrentHashMap.put(ContextManager.getInstance().getSession().getId(), new Subject(securityManager));
    }

    public static Subject getSubject() {
        return subjectConcurrentHashMap.get(ContextManager.getInstance().getSession().getId());
    }

    public static void removeSubject(HttpSession session) {
        subjectConcurrentHashMap.remove(session.getId());
    }


}
