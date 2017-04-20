package cn.impler.auth.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.impler.auth.dao.AuthDao;
import cn.impler.auth.dao.ResourceDao;
import cn.impler.auth.domain.Resource;
import cn.impler.auth.domain.ResourceRef;
import cn.impler.auth.domain.User;
import cn.impler.auth.domain.dto.ResourceSearchBean;
import cn.impler.auth.service.AbsAuthService;
import cn.impler.auth.service.ResourceService;


@Service
public class ResourceServiceImpl extends
		AbsAuthService<Resource, Integer, ResourceSearchBean> implements ResourceService {

	@Autowired
	private ResourceDao resDao;
	
	@Override
	protected AuthDao<Resource, Integer, ResourceSearchBean> getAuthDao() {
		return this.resDao;
	}

	@Override
	public Integer queryUserResourceIdByUrl(User user, String requestURI) {
		Integer resId = getDirectUrlId(user, requestURI);
		return null;
	}

	private Integer getDirectUrlId(User user, String requestURI) {
		// TODO Auto-generated method stub
		ResourceRef ref = new ResourceRef();
		ref.setLeftVal(user.getId());
		return null;
	}

	

}
