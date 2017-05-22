package cn.impler.auth.service;

import java.util.Set;

import cn.impler.auth.domain.Resource;
import cn.impler.auth.domain.User;

public interface UserResourceRefedService {

	/**
	 * query user all referenced resources
	 * including menu and link
	 * @param userId
	 * @return
	 */
	Set<Resource> queryUserAllRefedResources(Integer userId);

	/**
	 * query user top menus
	 * @param user
	 * @return
	 */
	Set<Resource> queryUserTopMenus(User user);

	/**
	 * query user sub menus
	 * @param parentId parent menu id
	 * @param user
	 * @return
	 */
	Set<Resource> queryUserSubMenus(Integer parentId, User user);

}
