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

	/**
	 * 条件查询排序
	 * @param map 查询条件
	 * @param isAsc 是否升序
	 * @param sortkey 排序条件
	 * @param num 获取个数
	 * @return
	 */
	List<T> findByConWithSort(Map map, boolean isAsc, String sortkey, Integer num);

	boolean update(T t);

}
