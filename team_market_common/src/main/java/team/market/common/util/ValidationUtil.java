package team.market.common.util;

import java.lang.reflect.Field;
import java.util.regex.Pattern;


public class ValidationUtil {
    private static String idCardReg = "[1-9]{2}[0-9]{4}(19|20)[0-9]{2}"
            + "((0[1-9]{1})|(1[1-2]{1}))((0[1-9]{1})|([1-2]{1}[0-9]{1}|(3[0-1]{1})))"
            + "[0-9]{3}[0-9x]{1}";
    private static String numberReg = "^[-\\\\+]?[\\\\d]*$";

    /**
     * @param idCard
     * @return
     * 如果身份证合法返回0
     * 如果身份证长度不合法返回1
     * 如果第1-17位含有非数字的字符返回2
     * 如果第18位不是数字也不是x返回3
     * 如果身份证号的出生日期非法返回4
     */
    public static int validateIdCard(String idCard) {
        Pattern pattern = Pattern.compile(idCardReg);
        return pattern.matcher(idCard).matches() ? 0 : 1;
    }

    public static String validateNull(Object obj, String remark) {
        try {
            for (Field f : obj.getClass().getDeclaredFields()) {
                f.setAccessible(true);
                if (f.getName().equals(remark)) {
                    continue;
                }
                if (f.get(obj) == null || f.get(obj) == "") {
                    return f.getName();
                }
            }
        } catch (Exception e) {
            return null;
        }
        return null;
    }

    public static boolean validateNumber(String numStr) {
        Pattern pattern = Pattern.compile(numberReg);
        return pattern.matcher(numStr).matches();
    }
}
