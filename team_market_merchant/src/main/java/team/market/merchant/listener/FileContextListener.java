package team.market.merchant.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.io.File;

public class FileContextListener implements ServletContextListener {

    public static final String UPLOAD = "/upload";

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        String uploadPath = sce.getServletContext().getRealPath(UPLOAD);
        File file = new File(uploadPath);
        if(!file.exists()){
            file.mkdirs();
        }
        sce.getServletContext().setAttribute("upload",uploadPath);

    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
