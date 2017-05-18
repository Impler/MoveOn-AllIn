package cn.impler.auth.dao.impl;

import java.util.List;
import java.util.Set;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import cn.impler.auth.dao.AbsAuthDao;
import cn.impler.auth.dao.ResourceDao;
import cn.impler.auth.domain.Resource;
import cn.impler.auth.domain.User;
import cn.impler.auth.domain.dto.ResourceSearchBean;
import cn.impler.auth.domain.dto.Url;

/**
 * resource dao implement
 * @author impler
 * @date 2017-02-16
 */
@Repository("resourceDao")
public class ResourceDaoImpl extends
		AbsAuthDao<ResourceDao, Resource, Integer, ResourceSearchBean>
		implements ResourceDao {

	@Override
	public Integer queryUserResourceIdByLiteralUrl(User user, Url url) {
		return super.getDao().queryUserResourceIdByLiteralUrl(user, url);
	}

	@Override
	public List<Resource> queryUserAntResources(User user) {
		return super.getDao().queryUserAntResources(user);
	}

	@Cacheable(value="userResources", key="#userId", unless="#result.size() > 0")
	@Override
	public Set<Resource> queryUserResources(Integer userId) {
		return super.getDao().queryUserResources(userId);
	}

	

}
