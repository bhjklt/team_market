package team.market_administrator;

import org.junit.Test;
import team.market.administrator.dao.AdFormDaoImpl;
import team.market.administrator.pojo.AdForm;
import team.market.common.auth.pojo.User;
import team.market.common.dao.BaseDaoImpl;
import team.market.common.dao.impl.UserDaoImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * @ Author     ：LILA3
 * @ Date       ：Created in 11:01 AM 7/14/2018
 */
public class BaseDaoTest {
    @Test
    public void testSave() {
        String uuid = String.valueOf(UUID.randomUUID());
        uuid = uuid.replaceAll("-", "");
        User user = new User();
        user.setUsername("anc");
        user.setId(uuid);
        BaseDaoImpl abstractBaseDao = new BaseDaoImpl();
        abstractBaseDao.save(user);
    }

    @Test
    public void testUpdate() {
        String uuid = String.valueOf(UUID.randomUUID());
        uuid = uuid.replaceAll("-", "");
        User user = new User();
        user.setId("499383defadc418cb20e378fb3f7a534");
        user.setUsername("update");
        BaseDaoImpl abstractBaseDao = new BaseDaoImpl();
        abstractBaseDao.update(user);
    }

    @Test
    public void testLoad() {
        BaseDaoImpl abstractBaseDao = new BaseDaoImpl();
        User user = (User) abstractBaseDao.find("499383defadc418cb20e378fb3f7a534");
        System.out.println();
    }

    @Test
    public void testDelete() {
        BaseDaoImpl abstractBaseDao = new BaseDaoImpl();
        abstractBaseDao.delete("499383defadc418cb20e378fb3f7a534");
    }

    @Test
    public void testFindAll() {
        BaseDaoImpl abstractBaseDao = new BaseDaoImpl();
        List<User> users = abstractBaseDao.findAll();
        System.out.println();
    }

    @Test
    public void testFindCon() {
        BaseDaoImpl abstractBaseDao = new BaseDaoImpl();
        Map map = new HashMap<String, String>();
        map.put("username", "anc");
        List<User> users = abstractBaseDao.findByCondition(map);
        System.out.println(users.get(0).getUsername());
    }

    @Test
    public  void  testOrderBy(){
        AdFormDaoImpl adFormDao = new AdFormDaoImpl();
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("sid", String.valueOf(1));
        List<AdForm> list =  adFormDao.findByConWithSort(map, false, "consume_time", 5);
    }


}
