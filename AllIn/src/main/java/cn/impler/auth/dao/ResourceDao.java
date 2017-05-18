package cn.impler.auth.dao;

import java.util.List;
import java.util.Set;

import org.apache.ibatis.annotations.Param;

import cn.impler.auth.domain.Resource;
import cn.impler.auth.domain.User;
import cn.impler.auth.domain.dto.ResourceSearchBean;
import cn.impler.auth.domain.dto.Url;

/**
 * resource dao
 * @author impler
 * @date 2017-02-16
 */
public interface ResourceDao extends AuthDao<Resource, Integer, ResourceSearchBean> {

	/**
	 * query user referenced resource id by literal url string
	 * @param user
	 * @param url
	 * @return
	 */
	Integer queryUserResourceIdByLiteralUrl(@Param("user") User user, @Param("url") Url url);

	/**
	 * query user referenced resource with Ant style url
	 * @param user
	 * @return
	 */
	List<Resource> queryUserAntResources(@Param("user") User user);
	
	/**
	 * query user referenced resources
	 * @param userId
	 * @return
	 */
	Set<Resource> queryUserResources(@Param("userId") Integer userId);

}
