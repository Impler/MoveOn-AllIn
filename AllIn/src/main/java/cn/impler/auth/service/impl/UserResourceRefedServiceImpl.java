package cn.impler.auth.service.impl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.impler.auth.dao.ResourceDao;
import cn.impler.auth.dao.UserDao;
import cn.impler.auth.domain.Resource;
import cn.impler.auth.domain.User;
import cn.impler.auth.dto.ResourceLevelEnum;
import cn.impler.auth.service.UserResourceRefedService;

@Service("userResourceRefedService")
public class UserResourceRefedServiceImpl implements UserResourceRefedService {

	@Autowired
	private UserDao userDao;
	
	@Autowired
	private ResourceDao resourceDao;

	@Override
	public Set<Resource> queryUserAllRefedResources(Integer userId) {
		return resourceDao.queryUserResources(userId);
	}

	@Override
	public Set<Resource> queryUserTopMenus(User user) {
		Set<Resource> menus = null;
		if(user.isAdmin()){
			// query all top menus
			menus = resourceDao.queryAllMenusByLevel(ResourceLevelEnum.L1);
		}else{
			// TODO
			// query user top menus
//			menus = resourceDao.queryUserMenusByLevel(user, );
		}
		return menus;
	}

}
