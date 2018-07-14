package team.market.common.util;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Enumeration;

public class WebUtil {

    public static <T> T request2Bean(HttpServletRequest request, Class<T> beanClass){
        T bean = null;
        try {
            bean = beanClass.newInstance();
            Method[] methods = beanClass.getMethods();
            Enumeration e = request.getParameterNames();
            while (e.hasMoreElements()) {
                String name = (String) e.nextElement();
                String value = request.getParameter(name);
                for (Method method : methods) {
                    if (method.getName().startsWith("set")) {
                        if (("set" + name).toUpperCase().equals(method.getName().toUpperCase())) {
                            String fieldName = beanClass.getDeclaredField(name).getType().getSimpleName();
                            ConvertClazzUtil convertClazz = ConvertClazzUtil.class.newInstance();
                            Method convertMethod = ConvertClazzUtil.class.getDeclaredMethod("convert" + fieldName, String.class);
                            Object convertValue = convertMethod.invoke(convertClazz, value);
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
