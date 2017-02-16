package cn.impler.auth.dao.impl;

import org.springframework.stereotype.Repository;

import cn.impler.auth.dao.AbsAuthDao;
import cn.impler.auth.dao.ResourceDao;
import cn.impler.auth.domain.Resource;
import cn.impler.auth.domain.dto.ResourceSearchBean;

/**
 * resource dao implement
 * @author impler
 * @date 2017-02-16
 */
@Repository("resourceDao")
public class ResourceDaoImpl extends
		AbsAuthDao<ResourceDao, Resource, Integer, ResourceSearchBean>
		implements ResourceDao {

}
