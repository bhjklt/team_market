package team.martket.common.util;


import org.junit.Assert;
import org.junit.Test;
import team.market.common.util.FileUtil;

/**
 * @author Thomas
 */
public class testFileUtil {


    @Test
    public void testcheckIFPic(){
        Assert.assertTrue(FileUtil.checkIFPic("www.jpeg"));
        Assert.assertTrue(FileUtil.checkIFPic("www.png"));
        Assert.assertTrue(FileUtil.checkIFPic("www.jpg"));
    }
}
