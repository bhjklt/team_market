package team.market.common.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public interface BaseDao<T, PK extends Serializable> {

	T find(PK pk);

	List<T> findAll();

	T save(T t);

	boolean delete(PK pk);

	List<T> findByCondition(Map map);
	
	boolean update(T t);

}
