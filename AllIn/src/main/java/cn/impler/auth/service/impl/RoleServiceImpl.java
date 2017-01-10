package cn.impler.auth.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.impler.auth.dao.RoleDao;
import cn.impler.auth.domain.Role;
import cn.impler.auth.domain.dto.RoleSearchBean;
import cn.impler.auth.service.RoleService;
import cn.impler.framework.mybatis.dao.dto.Pagination;

@Service("roleService")
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleDao roleDao;
	
	@Override
	public int add(Role role) {
		return roleDao.insert(role);
	}

	@Override
	public List<Role> selectInPagination(RoleSearchBean search, Pagination page) {
		
		return roleDao.selectInPagination(search, page);
	}

}
