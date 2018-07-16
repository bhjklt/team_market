package team.market.customer.service.impl;

import team.market.customer.dao.ProductDao;
import team.market.customer.dao.impl.ProductDaoImpl;
import team.market.customer.pojo.Product;
import team.market.customer.service.ProductService;

import java.util.List;
import java.util.Map;

public class ProductServiceImpl implements  ProductService{

    private ProductDao productDao = new ProductDaoImpl();

    @Override
    public Product find(String s) {
        return null;
    }

    @Override
    public List<Product> findAll() {
        return null;
    }

    @Override
    public Product save(Product product) {
        return null;
    }

    @Override
    public boolean delete(String s) {
        return false;
    }

    @Override
    public List<Product> findByCondition(Map map) {
        return productDao.findByCondition(map);
    }

    @Override
    public boolean update(Product product) {
        return false;
    }

    @Override
    public List<Product> findProductsBySid(String sid) {
        return productDao.findProductsBySid(sid);
    }
}
