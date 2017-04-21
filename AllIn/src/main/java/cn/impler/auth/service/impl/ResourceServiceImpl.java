package cn.impler.auth.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.impler.auth.dao.AuthDao;
import cn.impler.auth.dao.ResourceDao;
import cn.impler.auth.domain.Resource;
import cn.impler.auth.domain.User;
import cn.impler.auth.domain.dto.ResourceSearchBean;
import cn.impler.auth.domain.dto.Url;
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
		// query resource by literal url string
		Integer resId = getLiteralUrlId(user, requestURI);
		if (null != resId) {
			return resId;
		} 
		// if not exists, check whether matches Ant urls 
		else {
			return getAntUrlId(user, requestURI);
		}
	}

	/**
	 * query resource by literal url string
	 * @param user
	 * @param requestURI
	 * @return
	 */
	private Integer getLiteralUrlId(User user, String requestURI) {

		Url url = new Url(requestURI, ResourceUrlTypeEnum.LITERAL);

		return this.resDao.queryUserResourceIdByLiteralUrl(user, url);
	}

	/**
	 * query resource by Ant url
	 * @param user
	 * @param requestURI
	 * @return
	 */
	private Integer getAntUrlId(User user, String requestURI) {
		
		// 缓存
		List<Resource> resources = this.resDao.queryUserAntResources(user);
		
		if(null != resources){
			for(Resource r : resources){
				if(r.getUrl().match(requestURI)){
					return r.getId();
				}
			}
		}
		return null;
	}

}
