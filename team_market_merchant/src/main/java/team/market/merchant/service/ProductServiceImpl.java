package team.market.merchant.service;

import team.market.common.util.UUIDUtils;
import team.market.merchant.dao.impl.ProductDaoImpl;
import team.market.merchant.pojo.Product;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductServiceImpl implements ProductService {

    private static ProductDaoImpl productDao = new ProductDaoImpl();

    @Override
    public Product find(String s) {
        return productDao.find(s);
    }

    @Override
    public List<Product> findAll() {
        return productDao.findAll();
    }

    @Override
    public Product save(Product product) {
        product.setId(UUIDUtils.getUUID());
        return productDao.save(product);
    }

    @Override
    public boolean delete(String s) {
        return productDao.delete(s);
    }

    @Override
    public List<Product> findByCondition(Map map) {
        return productDao.findByCondition(map);
    }

    @Override
    public boolean update(Product product) {
        return productDao.update(product);
    }

    public List<Product> findAllBySId(String sId) {
        Map<String, String> conditions = new HashMap<>();
        conditions.put("sid", sId);
        return productDao.findByCondition(conditions);
    }

}
