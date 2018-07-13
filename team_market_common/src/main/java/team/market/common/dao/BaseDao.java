package teamproject;

import java.io.Serializable;
import java.util.List;

public interface BaseDao<T,PK extends Serializable> {
	
	public int add(T t);
	
	public int update(PK pk, T t);

	public int delete(PK pk);
	
	public List<T> findAll();
	
	public T findById(PK pk);

}
