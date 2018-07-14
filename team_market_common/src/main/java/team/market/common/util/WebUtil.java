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
                    if (method.getName().startsWith("set") && ("set" + name).toUpperCase().equals(method.getName().toUpperCase())) {
                        if(values != null && values.length > 0){
                            String fieldName = beanClass.getDeclaredField(name).getType().getSimpleName();
                            ConvertClazzUtil convertClazz = ConvertClazzUtil.class.newInstance();
                            Method convertMethod = ConvertClazzUtil.class.getDeclaredMethod("convert" + fieldName, String.class);
                            Object convertValue = convertMethod.invoke(convertClazz, values[values.length - 1]);
                            method.invoke(bean, convertValue);
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
