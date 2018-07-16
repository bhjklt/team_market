package team.market.merchant.listener;

import team.market.common.util.FileUtil;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.io.File;

public class FileContextListener implements ServletContextListener {

    public static final String UPLOAD = "/upload";

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        //String uploadPath = sce.getServletContext().getRealPath(UPLOAD);
        //System.out.println(uploadPath);
        //File file = new File(uploadPath);
        File file = FileUtil.getUploadFolder();
        if(!file.exists()){
            file.mkdirs();
        }
        //sce.getServletContext().setAttribute("upload",uploadPath);

    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
