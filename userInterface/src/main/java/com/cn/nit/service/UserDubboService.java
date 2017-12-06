package com.cn.nit.service;


import com.cn.nit.common.service.IBaseService;
import com.cn.nit.entity.User;

/**
 * Created by chenliangjun on 2017/5/11.
 */
public interface UserDubboService extends IBaseService<User,Integer> {
    public boolean addUser(User user);
    public boolean isExist();
    public boolean isExist(String username);
    public long get4Sex(String sex);

}
