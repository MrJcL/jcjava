package com.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;

public interface BaseDao<T> {

	
	
	public Serializable add(T t);
	
	public void delete(T t);
	
	public void update(T t);
	public T get(Class<T> tClass,Serializable id);
	
	public List<T> list(Criterion[] criterions,Class<T> entityClass,Order ...orders);
	
	public List<T> listByPage(Criterion[] criterions, int pageSize, int offset,Class<T> entityClass, Order... orders);
	public Integer count(Criterion[] criterions,Class<T> entityClass,Order ...orders);
			
}
