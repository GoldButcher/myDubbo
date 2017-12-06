package com.cn.nit.common.dao.impl;


import com.cn.nit.common.dao.IBaseDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.annotation.Resource;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class BaseDaoImpl<T,PK extends Serializable> implements IBaseDao<T,PK> {

	private Class<T> clazz;
	protected SessionFactory sessionFactory;
	@SuppressWarnings("unchecked")
	public BaseDaoImpl() {  
		this.clazz = null;
		Type superClass = getClass().getGenericSuperclass();
	         if(superClass instanceof ParameterizedType)
	         {
	        	 ParameterizedType parameterizedType = (ParameterizedType) superClass;
	         
	        	Type[] types = parameterizedType.getActualTypeArguments();
	            if(types != null && types.length>0){
	            	if(types[0] instanceof Class){
	            		clazz = (Class<T>) types[0];
	            	}
	            }
	         }
    }  
	@Resource
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public Session getSession(){
		Session session = sessionFactory.getCurrentSession();
		return session;
	}
	
	@SuppressWarnings("unchecked")
	public T get(Integer id) {
		return (T) getSession().get(clazz, id);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public T load(PK id) {	
		return (T) getSession().load(clazz, id);
	}
	
	@SuppressWarnings("unchecked")
	public PK save(T entity) {
		return (PK) getSession().save(entity);
	}

	public void update(T entity) {
		getSession().update(entity);
		
	}
	
	@Override
	public void delete(T entity) {
		getSession().delete(entity);
	}
	
	public void delete(PK id) {
		T entity = load(id);
		getSession().delete(entity);
	}
	@SuppressWarnings("unchecked")
	@Override
	public T get(String propertyName, Object value) {
		
		String hql = "from " + clazz.getName() + " as model where model."
				+ propertyName + " = ?";
		return (T) getSession().createQuery(hql).setParameter(0, value)
				.uniqueResult();
	}
	@Override
	public Long getTotalCount() {
		String hql = "select count(*) from " + clazz.getName();
		return (Long) getSession().createQuery(hql).uniqueResult();
	}



	
}
