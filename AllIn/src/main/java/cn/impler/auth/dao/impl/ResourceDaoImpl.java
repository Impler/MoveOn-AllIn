package cn.impler.auth.dao.impl;

import java.util.Set;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import cn.impler.auth.dao.AbsAuthDao;
import cn.impler.auth.dao.ResourceDao;
import cn.impler.auth.domain.Resource;
import cn.impler.auth.domain.dto.ResourceRefedSearchBean;
import cn.impler.auth.domain.dto.ResourceSearchBean;
import cn.impler.auth.dto.ResourceLevelEnum;

/**
 * resource dao implement
 * @author impler
 * @date 2017-02-16
 */
@Repository("resourceDao")
public class ResourceDaoImpl extends
		AbsAuthDao<ResourceDao, Resource, Integer, ResourceSearchBean>
		implements ResourceDao {


	@Cacheable(value="userResources", key="#userId", unless="#result.size() > 0")
	@Override
	public Set<Resource> queryUserResources(Integer userId) {
		return super.getDao().queryUserResources(userId);
	}

	@Override
	public Set<Resource> queryAllMenusByLevel(ResourceLevelEnum level) {
		return super.getDao().queryAllMenusByLevel(level);
	}

	@Override
	public Set<Resource> queryUserMenusByLevel(ResourceRefedSearchBean search) {
		return super.getDao().queryUserMenusByLevel(search);
	}

	@Override
	public Set<Resource> querySubMenusByParentId(Integer parentId) {
		
		return super.getDao().querySubMenusByParentId(parentId);
	}

	@Override
	public Set<Resource> queryUserSubMenusByParentId(
			ResourceRefedSearchBean search) {
		return super.getDao().queryUserSubMenusByParentId(search);
	}

}
