package team.market.common.util;

import java.lang.reflect.Method;
import java.util.Map;

public class WebUtil {


    public static <T> T request2Bean(Map<String,String[]> map, Class<T> beanClass){
        T bean = null;
        try {
            bean = beanClass.newInstance();
            Method[] methods = beanClass.getMethods();

            for(String name : map.keySet()){
                String[] values = map.get(name);
                for (Method method : methods) {
                    if (method.getName().startsWith("set")) {
                        if (("set" + name).toUpperCase().equals(method.getName().toUpperCase())) {
                            String fieldName = beanClass.getDeclaredField(name).getType().getSimpleName();
                            ConvertClazzUtil convertClazz = ConvertClazzUtil.class.newInstance();
                            Method convertMethod = ConvertClazzUtil.class.getDeclaredMethod("convert" + fieldName, String.class);
                            if(values.length > 0){
                                Object convertValue = convertMethod.invoke(convertClazz, values[values.length - 1]);
                                method.invoke(bean, convertValue);
                            }
                        }
                    }
                }
            }
        }catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return bean;

    }

}
