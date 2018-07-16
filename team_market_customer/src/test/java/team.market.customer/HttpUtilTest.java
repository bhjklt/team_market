package team.market.customer;

import org.junit.Test;
import team.market.common.util.HttpUtil;

public class HttpUtilTest {


    @Test
    public void getADStoreByHttpTest(){
        String urlGetADStore= "http://10.222.29.195:9090/c/api?method=getAd";
        String jsonsAdStore = HttpUtil.doGet(urlGetADStore);
        System.out.println(jsonsAdStore);
    }

    @Test
    public void getStoreByHttpTest(){
        String urlGetStore= "http://10.222.29.195:9090/store?method=available" ;
        String jsonsStore = HttpUtil.doGet(urlGetStore);
        System.out.println(jsonsStore);
    }
}
