package cn.impler.auth.service.impl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import cn.impler.auth.dao.ResourceDao;
import cn.impler.auth.domain.Resource;
import cn.impler.auth.domain.User;
import cn.impler.auth.domain.dto.ResourceRefedSearchBean;
import cn.impler.auth.dto.ResourceLevelEnum;
import cn.impler.auth.dto.ResourceTypeEnum;
import cn.impler.auth.service.UserResourceRefedService;

@Service("userResourceRefedService")
public class UserResourceRefedServiceImpl implements UserResourceRefedService {

	@Autowired
	private ResourceDao resourceDao;

	public UserResourceRefedServiceImpl() {
		super();
	}

	@Override
	public Set<Resource> queryUserAllRefedResources(Integer userId) {
		return resourceDao.queryUserResources(userId);
	}

	@Override
	@Cacheable(value="userTopMenus", key="#user.id")
	public Set<Resource> queryUserTopMenus(User user) {
		Set<Resource> menus = null;
		if(user.isAdmin()){
			// query all top menus
			menus = resourceDao.queryAllMenusByLevel(ResourceLevelEnum.L1);
		}else{
			ResourceRefedSearchBean search = new ResourceRefedSearchBean();
			search.setLevel(ResourceLevelEnum.L1);
			search.setType(ResourceTypeEnum.MENU);
			search.setOwner(user);
			// query user top menus
			menus = resourceDao.queryUserMenusByLevel(search);
		}
		return menus;
	}

	@Override
	@Cacheable(value="userSubMenus", key="#user.id" + "_#p0")
	public Set<Resource> queryUserSubMenus(Integer parentId, User user) {
		Set<Resource> menus = null;
		if(user.isAdmin()){
			menus = resourceDao.querySubMenusByParentId(parentId);
		}else{
			ResourceRefedSearchBean search = new ResourceRefedSearchBean();
			search.setOwner(user);
			search.setParentId(parentId);
			search.setType(ResourceTypeEnum.MENU);
			menus = resourceDao.queryUserSubMenusByParentId(search);
		}
		return menus;
	}

}
