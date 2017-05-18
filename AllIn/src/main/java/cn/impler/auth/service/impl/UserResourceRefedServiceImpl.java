package cn.impler.auth.service.impl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.impler.auth.dao.ResourceDao;
import cn.impler.auth.dao.UserDao;
import cn.impler.auth.domain.Resource;
import cn.impler.auth.service.UserResourceRefedService;

@Service("userResourceRefedService")
public class UserResourceRefedServiceImpl implements UserResourceRefedService {

	@Autowired
	private UserDao userDao;
	
	@Autowired
	private ResourceDao resourceDao;

	@Override
	public Set<Resource> queryUserRefedResources(Integer userId) {
		return resourceDao.queryUserResources(userId);
	}

}
