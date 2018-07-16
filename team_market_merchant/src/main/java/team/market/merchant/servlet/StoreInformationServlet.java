package team.market.merchant.servlet;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import team.market.common.auth.SecurityUtils;
import team.market.common.auth.pojo.User;
import team.market.common.servlet.BaseServlet;
import team.market.common.util.*;
import team.market.merchant.pojo.StoreForm;
import team.market.merchant.pojo.StoreInformation;
import team.market.merchant.service.StoreInformationServiceImpl;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Burgess Li
 */
public class StoreInformationServlet extends BaseServlet {

    private static StoreInformationServiceImpl storeInformationService = new StoreInformationServiceImpl();

    public String index(HttpServletRequest request, HttpServletResponse response) throws Exception {

        Map<String, String> reqParams = new HashMap<>();
        reqParams.put("USER_ID", ((User)SecurityUtils.getSubject().getAuthorizingInfo()).getId());
        String storeFormJson  = HttpUtil.doPost(API.GET_STORE_FORM, reqParams);


        StoreInformation storeInformation = null;

        if (!storeFormJson.isEmpty()) {
            StoreForm storeForm = JsonUtil.json2pojo(storeFormJson, StoreForm.class);
            storeInformation = storeInformationService.findBySId(storeForm.getStore().getId());
        }

        request.setAttribute("storeInformation", storeInformation);

        return "/add_store_information.jsp";
    }

    public String add(HttpServletRequest request, HttpServletResponse response) throws Exception {

        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);
        List<FileItem> items = upload.parseRequest(request);

        Map<String, String[]> params = new HashMap<>();

        for (FileItem item: items) {
            if (item.isFormField()) {
                params.put(item.getFieldName(), new String[]{item.getString("UTF-8")});
            } else {
                InputStream in = item.getInputStream();
                String newFileName = FileUtil.copyFileInput(in, FileUtil.getUploadFolder().getAbsolutePath(), item.getName());
                params.put(item.getFieldName(), new String[]{newFileName});
            }
        }

        StoreInformation storeInformation = (StoreInformation) WebUtil.parseRequest(new StoreInformation(), params, StoreInformation.class);

        Map<String, String> reqParams = new HashMap<>();
        reqParams.put("USER_ID", ((User)SecurityUtils.getSubject().getAuthorizingInfo()).getId());
        String storeFormJson  = HttpUtil.doPost(API.GET_STORE_FORM, reqParams);


        if (!storeFormJson.isEmpty()) {
            StoreForm storeForm = JsonUtil.json2pojo(storeFormJson, StoreForm.class);
            storeInformation.setSId(storeForm.getStore().getId());
            storeInformationService.save(storeInformation);
        }

        return "/success.jsp";

    }

    public String update(HttpServletRequest request, HttpServletResponse response) throws Exception {

        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);
        List<FileItem> items = upload.parseRequest(request);

        Map<String, String[]> params = new HashMap<>();

        for (FileItem item: items) {
            if (item.isFormField()) {
                params.put(item.getFieldName(), new String[]{item.getString("UTF-8")});
            } else if (item.getSize() > 0){
                InputStream in = item.getInputStream();
                String newFileName = FileUtil.copyFileInput(in, FileUtil.getUploadFolder().getAbsolutePath(), item.getName());
                params.put(item.getFieldName(), new String[]{newFileName});
            }
        }

        StoreInformation storeInformation = (StoreInformation) WebUtil.parseRequest(new StoreInformation(), params, StoreInformation.class);
        if (storeInformation.getImages() == null) {
            storeInformation.setId(storeInformationService.find(storeInformation.getId()).getImages());
        }
        storeInformationService.update(storeInformation);

        return "/store_information?method=index";
    }

}
