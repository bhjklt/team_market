package team.martket.common.util;

import org.junit.Test;
import team.market.common.util.Md5Utils;

public class MD5Test {


    @Test
    public void testPwdToMD5(){

        System.out.println(Md5Utils.md5Password("123456"));
    }

}
