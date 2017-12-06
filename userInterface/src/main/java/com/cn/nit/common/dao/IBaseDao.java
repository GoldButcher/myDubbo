package com.cn.nit.common.dao;

import java.io.Serializable;

public interface IBaseDao<T,PK extends Serializable> {
	T get(Integer id);
	T get(String propertyName, Object value);
	T load(PK id);
	Serializable save(T entity);
	void update(T entity);
	void delete(PK id);
	void delete(T entity);
	Long getTotalCount();
}
