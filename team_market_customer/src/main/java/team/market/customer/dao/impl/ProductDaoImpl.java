package team.market.customer.dao.impl;

import team.market.common.dao.BaseDaoImpl;
import team.market.common.util.ConnectionManager;
import team.market.customer.dao.ProductDao;
import team.market.customer.pojo.Product;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDaoImpl extends BaseDaoImpl<Product,String> implements ProductDao {

    @Override
    public List<Product> findProductsBySid(String sid) {
        List<Product> products = new ArrayList<>();
        String sql = "select * from mc_product where sid = ?";
        try {
            PreparedStatement statement = ConnectionManager.getInstance().prepareStatement(sql);
            statement.setString(1,sid);
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                Product product = new Product(rs.getString("id"),rs.getString("sid"),rs.getString("name"),
                        rs.getString("description"),rs.getString("images"),rs.getDouble("price"),
                        rs.getInt("quantity"),rs.getDate("create_time"));
                products.add(product);
            }
            statement.close();
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }
}
