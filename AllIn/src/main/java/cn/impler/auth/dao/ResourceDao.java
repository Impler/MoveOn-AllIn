package cn.impler.auth.dao;

import java.util.Set;

import org.apache.ibatis.annotations.Param;

import cn.impler.auth.domain.Resource;
import cn.impler.auth.domain.dto.ResourceRefedSearchBean;
import cn.impler.auth.domain.dto.ResourceSearchBean;
import cn.impler.auth.dto.ResourceLevelEnum;

/**
 * resource dao
 * @author impler
 * @date 2017-02-16
 */
public interface ResourceDao extends AuthDao<Resource, Integer, ResourceSearchBean> {

	/**
	 * query user referenced resources
	 * @param userId
	 * @return
	 */
	Set<Resource> queryUserResources(@Param("userId") Integer userId);

	/**
	 * query all menus by level
	 * @param level
	 * @return
	 */
	Set<Resource> queryAllMenusByLevel(ResourceLevelEnum level);

	/**
	 * query user referenced menu by level
	 * @param search
	 * @return
	 */
	Set<Resource> queryUserMenusByLevel(ResourceRefedSearchBean search);

	/**
	 * query sub menus by parent menu id
	 * @param parentId
	 * @return
	 */
	Set<Resource> querySubMenusByParentId(Integer parentId);

	/**
	 * query user sub menus by parent menu id
	 * @param search
	 * @return
	 */
	Set<Resource> queryUserSubMenusByParentId(ResourceRefedSearchBean search);

}
