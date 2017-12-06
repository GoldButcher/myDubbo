package com.cn.nit.service;


import com.cn.nit.common.service.IBaseService;
import com.cn.nit.entity.User;

public interface IUserService extends IBaseService<User,Integer> {
	public boolean addUser(User user);
	public boolean isExist();
	public boolean isExist(String username);
	public long get4Sex(String sex);

}
