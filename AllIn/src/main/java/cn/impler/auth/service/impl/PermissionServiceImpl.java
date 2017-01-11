package cn.impler.auth.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.impler.auth.dao.AuthDao;
import cn.impler.auth.dao.PermissionDao;
import cn.impler.auth.domain.Permission;
import cn.impler.auth.domain.dto.PermissionSearchBean;
import cn.impler.auth.service.AbsAuthService;
import cn.impler.auth.service.PermissionService;

/**
 * permission service implement
 * @author impler
 * @date 2017-01-11
 */
@Service("permissionService")
public class PermissionServiceImpl extends 
		AbsAuthService<Permission, Integer, PermissionSearchBean> 
		implements PermissionService {

	@Autowired
	private PermissionDao permissionDao;
	
	@Override
	protected AuthDao<Permission, Integer, PermissionSearchBean> getAuthDao() {
		return permissionDao;
	}

	


}
