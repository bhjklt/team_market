package team.market.common.util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class WebUtil {

    private static Method getMethod(Method[] methods, String methodName) {
        for (Method method: methods)
            if (method.getName().equals(methodName))
                return method;
        return null;
    }

    public static Object parseRequest(Object parent, Map<String, String[]> map, Class cls) throws Exception {
        for(Field field: cls.getDeclaredFields()) {
            Method method = getMethod(cls.getMethods(), "set" + field.getName().substring(0, 1).toUpperCase() + field.getName().substring(1));
            if (method != null) {
                String[] values = map.get(parent.getClass().getSimpleName() + "." + field.getName());
                switch (field.getType().getSimpleName().toUpperCase()) {
                    case "INTEGER":
                        method.invoke(parent, values == null ? null : Integer.valueOf(values[0]));
                        break;
                    case "LONG":
                        method.invoke(parent, values == null ? null : Long.valueOf(values[0]));
                        break;
                    case "SHORT":
                        method.invoke(parent, values == null ? null : Short.valueOf(values[0]));
                        break;
                    case "STRING":
                        method.invoke(parent, values == null ? null : values[0]);
                        break;
                    case "CHAR":
                        method.invoke(parent, values == null ? null : values[0].toCharArray()[0]);
                        break;
                    case "FLOAT":
                        method.invoke(parent, values == null ? null : Float.valueOf(values[0]));
                        break;
                    case "DOUBLE":
                        method.invoke(parent, values == null ? null : Double.valueOf(values[0]));
                        break;
                    case "BOOLEAN":
                        method.invoke(parent, values == null ? null : Boolean.valueOf(values[0]));
                        break;
                    default:
                        if (field.getType() != Set.class && field.getType() != List.class && field.getType() != Date.class) {
                            Object obj = field.getType().newInstance();
                            parseRequest(obj, map, field.getType());
                            method.invoke(parent, obj);
                        }
                }
            }
        }
        return parent;
    }


}
