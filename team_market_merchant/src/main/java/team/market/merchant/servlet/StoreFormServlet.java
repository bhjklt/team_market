package team.market.merchant.servlet;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUpload;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletRequestContext;
import team.market.common.servlet.BaseServlet;
import team.market.common.util.FileUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StoreFormServlet extends BaseServlet {

    private static final String NO_TYPE_FILE="文件格式不符合";


    public void apply(HttpServletRequest req, HttpServletResponse resp) throws Exception{
        String uploadPath = this.getServletContext().getRealPath("/upload");
        FileUpload fUpload = new FileUpload(new DiskFileItemFactory());
        Map<String,String> paramsMap = new HashMap<String,String>();
        try {
            List<FileItem> fileItems = fUpload.parseRequest(new ServletRequestContext(req));
            for(FileItem item:fileItems) {
                if(item.isFormField()) {
                    paramsMap.put(item.getFieldName(),item.getString("UTF-8"));
                }
                else {
                    String fileName = item.getName();
                    if(!FileUtil.checkIFPic(fileName)) {
                        req.setAttribute("error", NO_TYPE_FILE);
                        req.getRequestDispatcher("index.jsp").forward(req,resp);
                    }
                    InputStream in = item.getInputStream();
                    String newFileName = FileUtil.copyFileInput(in, uploadPath, fileName);
                    if(newFileName!=null){

                    }
                    in.close();
                }
            }
        } catch (FileUploadException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }



}
