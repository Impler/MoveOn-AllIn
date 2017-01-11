package cn.impler.auth.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.impler.auth.dao.AuthDao;
import cn.impler.auth.dao.RoleDao;
import cn.impler.auth.domain.Role;
import cn.impler.auth.domain.dto.RoleSearchBean;
import cn.impler.auth.service.AbsAuthService;
import cn.impler.auth.service.RoleService;

/**
 * role service implement
 * @author impler
 * @date 2017-01-11
 */
@Service("roleService")
public class RoleServiceImpl 
		extends AbsAuthService<Role, Integer, RoleSearchBean> 
		implements RoleService {

	@Autowired
	private RoleDao roleDao;
	
	@Override
	protected AuthDao<Role, Integer, RoleSearchBean> getAuthDao() {
		return roleDao;
	}

	



}
