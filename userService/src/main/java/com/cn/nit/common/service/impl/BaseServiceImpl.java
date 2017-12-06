package com.cn.nit.common.service.impl;

import com.cn.nit.common.dao.IBaseDao;
import com.cn.nit.common.service.IBaseService;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;

@Transactional
public class BaseServiceImpl<T,PK extends Serializable> implements IBaseService<T, PK> {
	
	private IBaseDao<T, PK> baseDao;
	
	public IBaseDao<T, PK> getBaseDao() {
		return baseDao;
	}

	public void setBaseDao(IBaseDao<T, PK> baseDao) {
		this.baseDao = baseDao;
	}

	@Override
	public T get(Integer id) {
		return baseDao.get(id);
	}

	@Override
	public T get(String propertyName, Object value) {
		return baseDao.get(propertyName, value);
	}

	@SuppressWarnings("unchecked")
	@Override
	public PK save(T entity) {
		return (PK) baseDao.save(entity);
	}

	@Override
	public void update(T entity) {
		baseDao.update(entity);
		
	}

	@Override
	public void delete(PK id) {
		baseDao.delete(id);
		
	}

	@Override
	public Long getTotalCount() {
		return baseDao.getTotalCount();
	}

	@Override
	public T load(PK id) {
		return baseDao.load(id);
	}

	@Override
	public void delete(T entity) {
		baseDao.delete(entity);
	}


}
