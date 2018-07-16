package team.market.merchant.servlet;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUpload;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import team.market.common.auth.SecurityUtils;
import team.market.common.auth.pojo.User;
import team.market.common.servlet.BaseServlet;
import team.market.common.util.FileUtil;
import team.market.common.util.HttpUtil;
import team.market.common.util.JsonUtil;
import team.market.common.util.WebUtil;
import team.market.merchant.dao.impl.ProductDaoImpl;
import team.market.merchant.pojo.Product;
import team.market.merchant.pojo.StoreForm;
import team.market.merchant.service.ProductService;
import team.market.merchant.service.ProductServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductServlet extends BaseServlet {

    private static ProductServiceImpl productService = new ProductServiceImpl();

    private static final String API = "http://10.222.29.195:9090/m/api?method=getStoreForm";

    public String add(HttpServletRequest request, HttpServletResponse response) throws Exception {

        String uploadPath = (String) this.getServletContext().getAttribute("upload");

        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);
        List<FileItem> items = upload.parseRequest(request);

        Map<String, String[]> params = new HashMap<>();

        for (FileItem item: items) {
            if (item.isFormField()) {
                params.put(item.getFieldName(), new String[]{item.getString("UTF-8")});
            } else {
                InputStream in = item.getInputStream();
                String newFileName = FileUtil.copyFileInput(in, uploadPath, item.getName());
                params.put(item.getFieldName(), new String[]{newFileName});
            }
        }

        Product product = (Product) WebUtil.parseRequest(new Product(), params, Product.class);

        Map<String, String> reqParams = new HashMap<>();
        reqParams.put("USER_ID", ((User)SecurityUtils.getSubject().getAuthorizingInfo()).getId());
        String storeFormJson  = HttpUtil.doPost(API, reqParams);


        if (!storeFormJson.isEmpty()) {
            StoreForm storeForm = JsonUtil.json2pojo(storeFormJson, StoreForm.class);
            product.setsId(storeForm.getStore().getId());
            productService.save(product);
        }

        return "/dashboard?method=index";
    }

    public String all(HttpServletRequest request, HttpServletResponse response) throws Exception {



        Map<String, String> reqParams = new HashMap<>();
        reqParams.put("USER_ID", ((User)SecurityUtils.getSubject().getAuthorizingInfo()).getId());
        String storeFormJson  = HttpUtil.doPost(API, reqParams);


        if (!storeFormJson.isEmpty()) {
            StoreForm storeForm = JsonUtil.json2pojo(storeFormJson, StoreForm.class);
            request.setAttribute("products", productService.findAllBySId(storeForm.getStore().getId()));
            response.getWriter().write("success");
        }

        return "products.jsp";
    }

    public String delete(HttpServletRequest request, HttpServletResponse response) throws Exception {

        productService.delete(request.getParameter("id"));

        return "/product?method=all";
    }

}
