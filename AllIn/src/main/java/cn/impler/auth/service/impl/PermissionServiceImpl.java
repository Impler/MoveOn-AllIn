package cn.impler.auth.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import cn.impler.auth.domain.Permission;
import cn.impler.auth.domain.dto.PermissionSearchBean;
import cn.impler.auth.service.PermissionService;
import cn.impler.framework.mybatis.dao.dto.Pagination;

@Service("permissionService")
public class PermissionServiceImpl implements PermissionService {

	@Override
	public int add(Permission role) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Permission> selectInPagination(PermissionSearchBean search,
			Pagination page) {
		// TODO Auto-generated method stub
		return null;
	}

}
