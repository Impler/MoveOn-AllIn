package cn.impler.auth.service;

import cn.impler.auth.domain.Resource;
import cn.impler.auth.domain.User;
import cn.impler.auth.domain.dto.ResourceSearchBean;

public interface ResourceService extends AuthService<Resource, Integer, ResourceSearchBean>{

	/**
	 * query user referenced resource id
	 * @param user
	 * @param requestURI
	 * @return
	 */
	Integer queryUserResourceIdByUrl(User user, String requestURI);

}
