package team.market.customer;

import org.junit.Test;
import team.market.customer.dao.ProductDao;
import team.market.customer.dao.impl.ProductDaoImpl;
import team.market.customer.pojo.Product;
import team.market.customer.service.ProductService;
import team.market.customer.service.impl.ProductServiceImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductTest {

    private ProductService productService = new ProductServiceImpl();

    @Test
    public void base(){
        String sid = "e86942ead2f94b2090b03893e9122fd7";
        Map<String,String> map = new HashMap<>();
        map.put("sid",sid);
        List<Product> products = productService.findProductsBySid(sid);
        System.out.println(products.size());
    }
}
