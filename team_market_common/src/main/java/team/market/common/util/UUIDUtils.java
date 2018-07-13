package team.market.common.util;

import java.util.UUID;

public class UUIDUtils {

    public static String get8UUID(){
        return UUID.randomUUID().toString().split("-")[0];
    }

    public static String getUUID(){
        return UUID.randomUUID().toString().replace("-", "");
    }
}
