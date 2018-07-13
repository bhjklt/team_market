package team.market.common.dao;

import java.io.Serializable;
import java.util.List;

public interface BaseDao<T, PK extends Serializable> {

	T find(PK pk);

	List<T> findAll();

	T save(T t);

	boolean delete(PK pk);
	
	boolean update(T t);

}
