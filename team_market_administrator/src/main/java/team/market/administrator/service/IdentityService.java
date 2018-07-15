package team.market.administrator.service;

import team.market.administrator.dao.IdentityDaoImpl;
import team.market.administrator.pojo.Identity;

public class IdentityService {
    IdentityDaoImpl identityDao = new IdentityDaoImpl();

    public Identity getIdentity(String id){
        return identityDao.find(id);
    }

    public void saveIdentity(Identity identity){
        identityDao.save(identity);
    }

}
