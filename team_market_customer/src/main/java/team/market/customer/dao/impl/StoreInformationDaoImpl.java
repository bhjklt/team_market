package team.market.customer.dao.impl;

import team.market.common.dao.BaseDaoImpl;
import team.market.common.util.ConnectionManager;
import team.market.customer.dao.StoreInformationDao;
import team.market.customer.pojo.StoreInformation;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StoreInformationDaoImpl extends BaseDaoImpl<StoreInformation,String> implements StoreInformationDao {

    @Override
    public List<StoreInformation> findStoreInformationsBySids(List<String> sids) {
        List<StoreInformation> storeInformations = new ArrayList<>();
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i<sids.size(); i++) {
            buffer.append("?,");
        }
        String sidsStr = buffer.toString();
        if(sidsStr.length()>0){
            sidsStr = sidsStr.substring(0,sidsStr.length()-1);
        }
        String sql = "select * from mc_storeinformation where sid in ("+sidsStr+")";
        try {
            PreparedStatement statement = ConnectionManager.getInstance().prepareStatement(sql);
            for (int i = 0; i<sids.size(); i++) {
                statement.setString(i+1,sids.get(i));
            }
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                StoreInformation storeInformation = new StoreInformation(rs.getString("id"),rs.getString("sid"),rs.getString("open"),rs.getString("close"),rs.getDouble("delivery_area"),rs.getString("description"),rs.getString("images"));
                storeInformations.add(storeInformation);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return storeInformations;
    }
}
