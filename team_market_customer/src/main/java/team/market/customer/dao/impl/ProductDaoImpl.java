package team.market.customer.dao.impl;

import team.market.common.dao.BaseDaoImpl;
import team.market.common.util.ConnectionManager;
import team.market.customer.dao.ProductDao;
import team.market.customer.pojo.Product;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ProductDaoImpl extends BaseDaoImpl<Product,String> implements ProductDao {

    @Override
    public List<Product> findProductsBySid(String sid) {
        List<Product> products = null;
        Product product = null;
        String sql = "select * from mc_product where sid = ?";
        try {
            PreparedStatement statement = ConnectionManager.getInstance().prepareStatement(sql);
            statement.setString(1,sid);
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                product.setId(rs.getString("id"));
                product.setsId(rs.getString("sid"));
                product.setName(rs.getString("name"));
                product.setDescription(rs.getString("description"));
                product.setImages(rs.getString("images"));
                product.setPrice(rs.getDouble("price"));
                product.setQuantity(rs.getInt("quantity"));
                product.setCreateTime(rs.getDate("create_time"));
                products.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }
}
