package team.market.customer.dao;

import team.market.common.dao.BaseDao;
import team.market.customer.pojo.StoreInformation;

import java.io.Serializable;
import java.util.List;

public interface StoreInformationDao extends BaseDao<StoreInformation,String> {

    public List<StoreInformation> findStoreInformationList(String[] sids);

}
