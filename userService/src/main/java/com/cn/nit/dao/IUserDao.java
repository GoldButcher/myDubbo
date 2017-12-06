package com.cn.nit.dao;



import com.cn.nit.common.dao.IBaseDao;
import com.cn.nit.entity.User;

import java.util.List;

public interface IUserDao extends IBaseDao<User, Integer> {
    public boolean isExist();

    public boolean isExist(String username);

    public long get4Sex(String sex);

}
