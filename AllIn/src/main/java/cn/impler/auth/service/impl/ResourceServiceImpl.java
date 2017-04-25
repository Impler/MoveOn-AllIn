package cn.impler.auth.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.impler.auth.dao.AuthDao;
import cn.impler.auth.dao.ResourceDao;
import cn.impler.auth.domain.Resource;
import cn.impler.auth.domain.User;
import cn.impler.auth.domain.dto.ResourceSearchBean;
import cn.impler.auth.dto.ResourceUrlTypeEnum;
import cn.impler.auth.service.AbsAuthService;
import cn.impler.auth.service.ResourceService;

@Service
public class ResourceServiceImpl extends
		AbsAuthService<Resource, Integer, ResourceSearchBean> implements
		ResourceService {

	@Autowired
	private ResourceDao resDao;

	@Override
	protected AuthDao<Resource, Integer, ResourceSearchBean> getAuthDao() {
		return this.resDao;
	}

	@Override
	public Integer queryUserResourceIdByUrl(User user, String requestURI) {
		
		List<Resource> resources = this.resDao.queryUserResources(user);

		if (null == resources || resources.isEmpty()) {
			return null;
		}

		for (Resource r : resources) {
			if (ResourceUrlTypeEnum.LITERAL.equals(r.getType())) {
				if (requestURI.equals(r.getUrl())) {
					return r.getId();
				}
			} else {
				if (r.getUrl().match(requestURI)) {
					return r.getId();
				}
			}
		}

		return null;
	}

}
