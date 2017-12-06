package com.cn.nit.interfaceimpl;

import com.cn.nit.common.service.impl.BaseServiceImpl;
import com.cn.nit.entity.User;
import com.cn.nit.service.IUserService;
import com.cn.nit.service.UserDubboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by chenliangjun on 2017/5/11.
 */
@Service("UserDobboServiceImpl")
@Transactional
public class UserDobboServiceImpl extends BaseServiceImpl<User,Integer> implements UserDubboService {
    @Autowired
    private IUserService userService;

    public boolean addUser(User user) {
        return (Boolean) userService.addUser(user);
    }

    public boolean isExist() {

        return userService.isExist();
    }

    public boolean isExist(String username) {
        return userService.isExist(username);
    }

    public long get4Sex(String sex) {
        return userService.get4Sex(sex);
    }

}
