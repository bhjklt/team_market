package team.martket.common.util;

import org.junit.Assert;
import org.junit.Test;
import team.market.common.util.UUIDUtils;

public class testUUIDUtils {

    @Test
    public void testGet8UUID(){
        Assert.assertNotNull(UUIDUtils.get8UUID());
        Assert.assertNotNull(UUIDUtils.get8UUID().length()==8);
    }

    @Test
    public void testGetUUID(){
        Assert.assertNotNull(UUIDUtils.getUUID());
        Assert.assertNotNull(UUIDUtils.getUUID().length()>0);
    }
}
