package team.market.customer.dao.impl;

import team.market.common.dao.BaseDaoImpl;
import team.market.common.util.ConnectionManager;
import team.market.customer.dao.StoreInformationDao;
import team.market.customer.pojo.StoreInformation;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class StoreInformationDaoImpl extends BaseDaoImpl<StoreInformation,String> implements StoreInformationDao {

    @Override
    public List<StoreInformation> findStoreInformationList(String[] sids) {
        List<StoreInformation> storeInformations = null;
        StoreInformation storeInformation = null;
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i<sids.length; i++) {
                buffer.append("?,");
        }
        String sidsStr = buffer.toString();
        sidsStr = sidsStr.substring(0,sidsStr.length()-1);
        String sql = "select * from mc_storeinformation where id in ("+sidsStr+")";
        try {
            PreparedStatement statement = ConnectionManager.getInstance().prepareStatement(sql);
            for (int i = 0; i<sids.length; i++) {
                statement.setString(i+1,sids[i]);
            }
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                storeInformation.setId(rs.getString("id"));
                storeInformation.setsId(rs.getString("sid"));
                storeInformation.setOpen(rs.getString("open"));
                storeInformation.setClose(rs.getString("close"));
                storeInformation.setDeliveryArea(rs.getDouble("deliveryArea"));
                storeInformation.setDescription(rs.getString("description"));
                storeInformation.setImages(rs.getString("images"));
                storeInformations.add(storeInformation);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return storeInformations;
    }
}
