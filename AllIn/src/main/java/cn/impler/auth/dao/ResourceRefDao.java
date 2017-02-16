package cn.impler.auth.dao;

import java.util.List;

import cn.impler.auth.domain.ResourceRef;

public interface ResourceRefDao extends
		AuthDao<ResourceRef, Integer, ResourceRef> {


	/**
	 * query left value referenced ids
	 * @param ref
	 * @return
	 */
	List<Integer> queryLeftValueRefedValues(ResourceRef ref);

	
}
