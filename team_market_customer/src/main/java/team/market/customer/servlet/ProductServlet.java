package team.market.customer.servlet;

import team.market.common.servlet.BaseServlet;
import team.market.customer.dao.ProductDao;
import team.market.customer.dao.impl.ProductDaoImpl;
import team.market.customer.pojo.Product;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ProductServlet extends BaseServlet {

    private ProductDao productDao = new ProductDaoImpl();

    public String getList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String sid = req.getParameter("sid");
        List<Product> products = productDao.findProductsBySid(sid);
        req.setAttribute("products",products);
        return "/WEB-INF/showProductList.jsp";
    }
}
