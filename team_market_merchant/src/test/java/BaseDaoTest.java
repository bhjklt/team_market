//import org.junit.Test;
//import team.market.common.dao.TestUserDaoImplImp;
//import team.market.common.pojo.User;
//
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//import java.util.UUID;
//
///**
// * @ Author     ：LILA3
// * @ Date       ：Created in 11:01 AM 7/14/2018
// */
//public class BaseDaoTest {
//    @Test
//    public void testSave(){
//        String uuid = String.valueOf(UUID.randomUUID());
//        uuid = uuid.replaceAll("-","");
//        User user = new User();
//        user.setUsername("anc");
//        user.setId(uuid);
//        TestUserDaoImplImp abstractBaseDao = new TestUserDaoImplImp();
//        abstractBaseDao.save(user);
//    }
//
//    @Test
//    public void testUpdate(){
//        String uuid = String.valueOf(UUID.randomUUID());
//        uuid = uuid.replaceAll("-","");
//        User user = new User();
//        user.setId("499383defadc418cb20e378fb3f7a534");
//        user.setUsername("update");
//        TestUserDaoImplImp abstractBaseDao = new TestUserDaoImplImp();
//        abstractBaseDao.update(user);
//    }
//
//    @Test
//    public void testLoad(){
//        TestUserDaoImplImp abstractBaseDao = new TestUserDaoImplImp();
//        User user = abstractBaseDao.find("499383defadc418cb20e378fb3f7a534");
//        System.out.println();
//    }
//
//    @Test
//    public  void testDelete(){
//        TestUserDaoImplImp abstractBaseDao = new TestUserDaoImplImp();
//        abstractBaseDao.delete("499383defadc418cb20e378fb3f7a534");
//    }
//
//    @Test
//    public void testFindAll(){
//        TestUserDaoImplImp abstractBaseDao = new TestUserDaoImplImp();
//        List<User> users = abstractBaseDao.findAll();
//        System.out.println();
//    }
//
//    @Test
//    public void testFindCon(){
//        TestUserDaoImplImp abstractBaseDao = new TestUserDaoImplImp();
//        Map map = new HashMap<String, String>();
//        map.put("username", "anc");
//        List<User> users = abstractBaseDao.findByCondition(map);
//        System.out.println(users.get(0).getUsername());
//    }
//
//
//
//}
