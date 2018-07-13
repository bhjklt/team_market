package team.market.common.util;

import java.util.UUID;

public class UUIDUtils {

    public static String get8UUID(){
        UUID id=UUID.randomUUID();
        String[] idd=id.toString().split("-");
        return idd[0];
    }
}
