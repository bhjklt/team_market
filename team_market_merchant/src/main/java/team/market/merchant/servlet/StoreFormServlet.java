package team.market.merchant.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUpload;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletRequestContext;
import team.market.common.servlet.BaseServlet;
import team.market.common.util.FileUtil;
import team.market.merchant.pojo.StoreForm;
import team.market.merchant.util.CovertParamsToBean;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StoreFormServlet extends BaseServlet {

    private static final String NO_TYPE_FILE="文件格式不符合";
    private static final String MAX_SIZE_ERROR="文件过大";
    private static final long MAX_SIZE = 2000000;

    private CovertParamsToBean cptb = new CovertParamsToBean();

    public void apply(HttpServletRequest req, HttpServletResponse resp) throws Exception{
        String uploadPath = (String) this.getServletContext().getAttribute("upload");
        FileUpload fUpload = new FileUpload(new DiskFileItemFactory());
        Map<String,String> paramsMap = new HashMap<String,String>();
        try {
            List<FileItem> fileItems = fUpload.parseRequest(new ServletRequestContext(req));
            String newFileName = null;
            for(FileItem item:fileItems) {
                if(item.isFormField()) {
                    paramsMap.put(item.getFieldName(),item.getString("UTF-8"));
                }
                else {
                    String fileName = item.getName();
                    if(!FileUtil.checkIFPic(fileName)||item.getSize()>MAX_SIZE) {
                        req.setAttribute("error", NO_TYPE_FILE+" or "+MAX_SIZE_ERROR);
                        //req.getRequestDispatcher("index.jsp").forward(req,resp);
                    }else {
                        InputStream in = item.getInputStream();
                        newFileName = FileUtil.copyFileInput(in, uploadPath, fileName);
                        in.close();
                    }
                }
            }
            if(newFileName!=null){
                paramsMap.put("Identity.idCardPic",newFileName);
                StoreForm storeForm = cptb.covertParamsToStFo(paramsMap);
                ObjectMapper objectMapper = new ObjectMapper();
                System.out.println(objectMapper.writeValueAsString(storeForm));
            }
        } catch (FileUploadException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }



}
