package team.market.customer.dao;

import team.market.common.dao.BaseDao;
import team.market.customer.pojo.Product;

import java.util.List;

public interface ProductDao extends BaseDao<Product,String> {

    public List<Product> findProductsBySid(String sid);
}
