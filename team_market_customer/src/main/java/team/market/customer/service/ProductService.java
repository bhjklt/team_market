package team.market.customer.service;

import team.market.common.service.BaseService;
import team.market.customer.pojo.Product;

import java.util.List;

public interface ProductService extends BaseService<Product,String> {

    public List<Product> findProductsBySid(String sid);
}
