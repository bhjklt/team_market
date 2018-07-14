package team.market.common.manager;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.util.concurrent.ConcurrentHashMap;

public class ContextManager {

    private static ContextManager contextManager = null;

    private ServletContext servletContext = null;
    private ConcurrentHashMap<String, HttpSession> sessionConcurrentHashMap = null;

    private ContextManager(ServletContext servletContext) {
        this.servletContext = servletContext;
        this.sessionConcurrentHashMap = new ConcurrentHashMap<String, HttpSession>();
    }

    public static void initializeManager(ServletContext servletContext) {
        System.out.println("initialize context manager");
        if (contextManager == null) {
            synchronized (ContextManager.class) {
                if (contextManager == null)
                    contextManager = new ContextManager(servletContext);
            }
        }
    }

    public static ContextManager getInstance() {
        return contextManager;
    }

    public ServletContext getServletContext() {
        return this.servletContext;
    }

    public void addSession(HttpSession session) {
        System.out.println("add temp session");
        String currentThreadId = String.valueOf(Thread.currentThread().getId());
        if (sessionConcurrentHashMap.containsKey(currentThreadId)) {
            System.err.println("can not add temp session");
            return;
        }
        this.sessionConcurrentHashMap.put(currentThreadId, session);
    }

    public HttpSession getSession() {
        return this.sessionConcurrentHashMap.get(String.valueOf(Thread.currentThread().getId()));
    }

    public void removeSession() {
        System.out.println("remove temp session");
        this.sessionConcurrentHashMap.remove(String.valueOf(Thread.currentThread().getId()));
    }

}
