package team.market.merchant.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUpload;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletRequestContext;
import team.market.common.auth.SecurityUtils;
import team.market.common.auth.Subject;
import team.market.common.auth.pojo.Permission;
import team.market.common.servlet.BaseServlet;
import team.market.common.util.FileUtil;
import team.market.common.util.JmsSender;
import team.market.merchant.pojo.StoreForm;
import team.market.merchant.pojo.User;
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
    private static final String MQQueue = "lance.queue";
    private static final String APPLY_HTML = "applicant.jsp";
    private static final String SUCCESS = "r:/success.jsp";

    private CovertParamsToBean cptb = new CovertParamsToBean();

    public String  apply(HttpServletRequest req, HttpServletResponse resp) throws Exception{
        String uploadPath = (String) this.getServletContext().getAttribute("upload");
        FileUpload fUpload = new FileUpload(new DiskFileItemFactory());


            Map<String, Object> paramsMap = new HashMap<String, Object>();
            try {
                User u = new User();
                Subject subject = SecurityUtils.getSubject();
                u.setId(((team.market.common.auth.pojo.User)subject.getAuthorizingInfo()).getId());
                paramsMap.put("user",u);
                List<FileItem> fileItems = fUpload.parseRequest(new ServletRequestContext(req));
                String newFileName = null;
                for (FileItem item : fileItems) {
                    if (item.isFormField()) {
                        paramsMap.put(item.getFieldName(), item.getString("UTF-8"));
                    } else {
                        String fileName = item.getName();
                        if (!FileUtil.checkIFPic(fileName) || item.getSize() > MAX_SIZE) {
                            req.setAttribute("error", NO_TYPE_FILE + " 或 " + MAX_SIZE_ERROR);
                            return APPLY_HTML;
                        } else {
                            InputStream in = item.getInputStream();
                            newFileName = FileUtil.copyFileInput(in, uploadPath, fileName);
                            req.removeAttribute("error");
                            in.close();
                        }
                    }
                }
                if (newFileName != null) {
                    paramsMap.put("Identity.idCardPic", newFileName);
                    StoreForm storeForm = cptb.covertParamsToStFo(paramsMap);
                    storeForm.getIdentity().setUserid(u.getId());
                    ObjectMapper objectMapper = new ObjectMapper();
                    String json = objectMapper.writeValueAsString(storeForm);
                    JmsSender jmsSender = new JmsSender();
                    jmsSender.sendMessage(MQQueue,json);
                    subject.removePermission(Permission.DefaultPermission.CREATE_STORE);
                }
            } catch (FileUploadException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }


        return SUCCESS;
    }



}
