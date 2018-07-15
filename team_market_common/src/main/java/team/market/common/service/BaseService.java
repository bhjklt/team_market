package team.market.common.service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public interface BaseService<T, PK extends Serializable> {

    T find(PK pk);

    List<T> findAll();

    T save(T t);

    boolean delete(PK pk);

    List<T> findByCondition(Map map);

    boolean update(T t);

}
