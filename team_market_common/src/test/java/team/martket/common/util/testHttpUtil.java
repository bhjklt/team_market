package team.martket.common.util;

import org.junit.Assert;
import org.junit.Test;
import team.market.common.util.HttpUtil;

import java.util.HashMap;
import java.util.Map;


/**
 * @author thomas
 */
public class testHttpUtil {


    @Test
    public void testHttpDoGet(){
        String result = HttpUtil.doGet("http://www.baidu.com");
        Assert.assertNotNull(result);
        Assert.assertTrue(result.length()>0);
    }


    @Test
    public void testHttpDoPost(){
        Map<String,String> params = new HashMap<String, String>();
        params.put("name","value");
        String result = HttpUtil.doPost("http://www.baidu.com",params);
        Assert.assertNotNull(result);
        Assert.assertTrue(result.length()>0);
    }

}
