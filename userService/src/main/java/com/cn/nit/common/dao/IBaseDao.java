package com.cn.nit.common.dao;

import java.io.Serializable;

public interface IBaseDao<T,PK extends Serializable> {
	public T get(Integer id);
	public T get(String propertyName, Object value);
	public T load(PK id);
	public Serializable save(T entity);
	public void update(T entity);    
	public void delete(PK id);
	public void delete(T entity);
	public Long getTotalCount();
}
