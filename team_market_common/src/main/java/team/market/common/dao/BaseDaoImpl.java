package team.market.common.dao;
/**
 * @ Author     ：LILA3
 * @ Date       ：Created in 4:42 PM 7/13/2018
 */

import team.market.common.annontation.ColumnIgnore;
import team.market.common.annontation.ColumnName;
import team.market.common.annontation.Table;
import team.market.common.util.ConnectionManager;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class BaseDaoImpl<T, PK extends Serializable> implements BaseDao<T, PK> {
    private Class<T> entityClass = null;

    public BaseDaoImpl() {
        Type genType = this.getClass().getGenericSuperclass();
        Type[] params = ((ParameterizedType) genType).getActualTypeArguments();
        entityClass = (Class) params[0];
    }

    @Override
    public T save(T entity) {
        String sql = "insert into " + getTableAnnotation(entityClass).toLowerCase() + "(";

        List<Method> list = getMethodWithGet(entityClass);
        for (Method getMethod : list) {
            sql += getColumnName(getMethod) + ",";
        }
        sql = sql.substring(0, sql.lastIndexOf(",")) + ") values(";

        for (Method getMethod : list) {
            sql += "?,";
        }
        sql = sql.substring(0, sql.lastIndexOf(",")) + ")";

        System.out.println(sql);

        try {
            int i = 1;
            PreparedStatement statement = ConnectionManager.getInstance().prepareStatement(sql);
            for (Method getMethod : list) {
                if (getMethod.getReturnType().getSimpleName().indexOf("String") != -1) {
                    statement.setString(i++, (String) getMethod.invoke(entity));
                } else if (getMethod.getReturnType().getSimpleName().indexOf("Date") != -1) {
                    statement.setDate(i++, (Date) getMethod.invoke(entity));
                } else if (getMethod.getReturnType().getSimpleName().indexOf("Double") != -1) {
                    statement.setDouble(i++, (Double) getMethod.invoke(entity));
                } else {
                    statement.setInt(i++, (Integer) getMethod.invoke(entity));
                }
            }
            if (statement.executeUpdate() > 0) {
                return entity;
            } else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean update(T entity) {
        String sql = "update " + getTableAnnotation(entityClass).toLowerCase() + " set ";

        List<Method> list = getMethodWithGet(entityClass);
        Method idMethod = null;
        for (Method getMethod : list) {
            if (getMethod.getName().substring(3).toLowerCase().equals("id")) {
                idMethod = getMethod;
                continue;
            }
            sql += getColumnName(getMethod) + " = ?,";
        }

        try {
            String id = (String) idMethod.invoke(entity);
            sql = sql.substring(0, sql.lastIndexOf(",")) + " where id = '" + id + "'";
            list.remove(0);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        System.out.println(sql);
        try {
            int i = 0;
            PreparedStatement statement = ConnectionManager.getInstance().prepareStatement(sql);
            for (Method getMethod : list) {
                if (getMethod.getReturnType().getSimpleName().indexOf("String") != -1) {
                    statement.setString(++i, (String) getMethod.invoke(entity));
                } else if (getMethod.getReturnType().getSimpleName().indexOf("Date") != -1) {
                    statement.setDate(++i, (Date) getMethod.invoke(entity));
                } else if (getMethod.getReturnType().getSimpleName().indexOf("Double") != -1) {
                    statement.setDouble(++i, (Double) getMethod.invoke(entity));
                } else {
                    statement.setInt(++i, (Integer) getMethod.invoke(entity));
                }
            }
            if (statement.executeUpdate() > 0) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean delete(PK pk) {
        String sql = "delete from " + getTableAnnotation(entityClass).toLowerCase();

        List<Method> list = getMethodWithGet(entityClass);
        try {
            sql = sql + " where id = '" + pk + "'";
            PreparedStatement statement = ConnectionManager.getInstance().prepareStatement(sql);
            if (statement.executeUpdate() > 0) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<T> findByCondition(Map map) {
        String sql = "select * from " + getTableAnnotation(entityClass).toLowerCase() + " where ";
        Set keys = map.keySet();
        for (Object key : keys) {
            sql += key.toString() + " = '" + map.get(key).toString() + "' and ";
        }
        sql = sql.substring(0, sql.indexOf("and"));
        System.out.println(sql);
        try {
            PreparedStatement statement = ConnectionManager.getInstance().prepareStatement(sql);
            ResultSet rs = statement.executeQuery();

            int i = 0;
            List<Method> list = getMethodWithSet(entityClass);
            List<T> entityLsit = new ArrayList<T>();
            while (rs.next()) {
                T entity = entityClass.newInstance();
                for (Method method : list) {

                    if (method.getParameterTypes()[0].getSimpleName().indexOf("String") != -1) {
                        method.invoke(entity, rs.getString(getColumnName(method)));
                    } else if (method.getParameterTypes()[0].getSimpleName().indexOf("Date") != -1) {
                        method.invoke(entity, rs.getDate(getColumnName(method)));

                    } else if (method.getParameterTypes()[0].getSimpleName().indexOf("Double") != -1) {
                        method.invoke(entity, rs.getDouble(getColumnName(method)));
                    } else {
                        method.invoke(entity, rs.getInt(getColumnName(method)));
                    }
                }
                entityLsit.add(entity);
            }
            rs.close();
            statement.close();
            return entityLsit;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public T find(PK pk) {
        String sql = "select * from " + getTableAnnotation(entityClass).toLowerCase() + " where id = '" + pk + "'";

        try {
            PreparedStatement statement = ConnectionManager.getInstance().prepareStatement(sql);
            T entity = entityClass.newInstance();

            List<Method> list = getMethodWithSet(entityClass);
            ResultSet rs = statement.executeQuery();
            int i = 0;
            while (rs.next()) {
                for (Method method : list) {

                    if (method.getParameterTypes()[0].getSimpleName().indexOf("String") != -1) {
                        method.invoke(entity, rs.getString(getColumnName(method)));
                    } else if (method.getParameterTypes()[0].getSimpleName().indexOf("Date") != -1) {
                        method.invoke(entity, rs.getDate(getColumnName(method)));
                    } else if (method.getParameterTypes()[0].getSimpleName().indexOf("Double") != -1) {
                        method.invoke(entity, rs.getDouble(getColumnName(method)));
                    } else {
                        method.invoke(entity, rs.getInt(getColumnName(method)));
                    }
                }
            }
            rs.close();
            statement.close();
            return entity;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    @Override
    public List<T> findAll() {
        String sql = "select * from " + getTableAnnotation(entityClass).toLowerCase();
        try {
            PreparedStatement statement = ConnectionManager.getInstance().prepareStatement(sql);
            ResultSet rs = statement.executeQuery();

            int i = 0;
            List<Method> list = getMethodWithSet(entityClass);
            List<T> entityLsit = new ArrayList<T>();
            while (rs.next()) {
                T entity = entityClass.newInstance();
                for (Method method : list) {

                    if (method.getParameterTypes()[0].getSimpleName().indexOf("String") != -1) {
                        method.invoke(entity, rs.getString(getColumnName(method)));
                    } else if (method.getParameterTypes()[0].getSimpleName().indexOf("Date") != -1) {
                        method.invoke(entity, rs.getDate(getColumnName(method)));
                    } else if (method.getParameterTypes()[0].getSimpleName().indexOf("Double") != -1) {
                        method.invoke(entity, rs.getDouble(getColumnName(method)));
                    } else {
                        method.invoke(entity, rs.getInt(getColumnName(method)));
                    }
                }
                entityLsit.add(entity);
            }
            rs.close();
            statement.close();
            return entityLsit;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    public List<Method> getMethodWithGet(Class<T> entityClass) {

        List<Method> getMethods = new ArrayList<Method>();
        Method[] methods = entityClass.getDeclaredMethods();
        for (Method method : methods) {
            if (method.getAnnotation(ColumnIgnore.class) != null)
                continue;
            if (method.getName().startsWith("get")) {
                getMethods.add(method);
            }
        }

        return getMethods;
    }

    public List<Method> getMethodWithSet(Class<T> entityClass) {

        List<Method> getMethods = new ArrayList<Method>();
        Method[] methods = entityClass.getDeclaredMethods();
        for (Method method : methods) {
            if (method.getAnnotation(ColumnIgnore.class) != null)
                continue;
            if (method.getName().startsWith("set")) {
                getMethods.add(method);
            }
        }

        return getMethods;
    }

    public String getTableAnnotation(Class<T> entityClass) {
        Table table = entityClass.getAnnotation(Table.class);
        return table.value();
    }

    public String getColumnName(Method method) {
        ColumnName columnName = method.getAnnotation(ColumnName.class);
        if (columnName != null) {
            return columnName.value().toLowerCase();
        } else {
            String methodName = method.getName();
            return methodName.substring(3).toLowerCase();
        }
    }
}

