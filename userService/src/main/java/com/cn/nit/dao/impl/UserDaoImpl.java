package com.cn.nit.dao.impl;


import com.cn.nit.common.dao.impl.BaseDaoImpl;
import com.cn.nit.dao.IUserDao;
import com.cn.nit.entity.User;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl extends BaseDaoImpl<User,Integer> implements IUserDao {

	@Override
	public boolean isExist() {
		String hql = "select count(*) from User";
		Long count = (Long) getSession().createQuery(hql).uniqueResult();
		if (count == 0) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public boolean isExist(String username) {
		if(get("userName", username)==null)
		{
			return false;
		}
		return true;
	}

	@Override
	public long get4Sex(String sex) {
		String hql = "select count(*) from User as user where user.userSex = :sex ";
		Query query = getSession().createQuery(hql);
		query.setParameter("sex", sex);
		return (Long) query.uniqueResult();
	}


}
