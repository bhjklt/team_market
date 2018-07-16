package team.market.customer.service;

import team.market.common.service.BaseService;
import team.market.customer.pojo.StoreInformation;

import java.util.List;

public interface StoreInformationService extends BaseService<StoreInformation,String> {

    public List<StoreInformation> findStoreInformationsBySids(List<String> sids);

}
