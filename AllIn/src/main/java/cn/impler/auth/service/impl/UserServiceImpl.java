package cn.impler.auth.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import cn.impler.auth.domain.User;
import cn.impler.auth.domain.dto.UserSearchBean;
import cn.impler.auth.service.UserService;
import cn.impler.framework.mybatis.dao.dto.Pagination;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Override
	public int add(User role) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<User> selectInPagination(UserSearchBean search, Pagination page) {
		// TODO Auto-generated method stub
		return null;
	}

}
