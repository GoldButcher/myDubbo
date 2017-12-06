package com.cn.nit.service.impl;

import com.cn.nit.common.service.impl.BaseServiceImpl;
import com.cn.nit.dao.IUserDao;
import com.cn.nit.entity.User;
import com.cn.nit.service.IUserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl extends BaseServiceImpl<User, Integer> implements IUserService {
	
	@Resource
	private IUserDao userdao;
	
	
	@Resource
	public void setUserdao(IUserDao userdao) {
		super.setBaseDao(userdao);
	}

	@Override
	public boolean addUser(User user) {
		return (Boolean) userdao.save(user);
	}

	@Override
	public boolean isExist() {

		return userdao.isExist();
	}
	
	@Override
	public boolean isExist(String username) {
		return userdao.isExist(username);
	}

	@Override
	public long get4Sex(String sex) {
		return userdao.get4Sex(sex);
	}

//	@Override
//	public UserTableDto getUser4DT(DataTable2User dataTables) {
//		List<User> data =  userdao.getUser4DT(dataTables);
//		Long count = userdao.getCount4DT(dataTables);
//		UserTableDto dto = new UserTableDto(dataTables.getDraw(), count, count, data);
//		for (User user : data) {
//			if(user.getCreateDate()!=null)
//			user.setDateStr(DateUtil.date2String(user.getCreateDate()));
//		}
//		return dto;
//	}
	
}
