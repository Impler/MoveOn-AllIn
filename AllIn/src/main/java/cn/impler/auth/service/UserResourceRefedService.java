package cn.impler.auth.service;

import java.util.Set;

import cn.impler.auth.domain.Resource;

public interface UserResourceRefedService {

	/**
	 * query user referenced resources
	 * @param userId
	 * @return
	 */
	Set<Resource> queryUserRefedResources(Integer userId);

}
