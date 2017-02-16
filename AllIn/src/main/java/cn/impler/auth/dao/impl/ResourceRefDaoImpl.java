package cn.impler.auth.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.impler.auth.dao.AbsAuthDao;
import cn.impler.auth.dao.ResourceRefDao;
import cn.impler.auth.domain.ResourceRef;

@Repository("resourceRefDao")
public class ResourceRefDaoImpl<D> extends
		AbsAuthDao<ResourceRefDao, ResourceRef, Integer, ResourceRef> implements
		ResourceRefDao {

	@Override
	public List<Integer> queryLeftValueRefedValues(ResourceRef ref) {
		
		return super.getDao().queryLeftValueRefedValues(ref);
	}


}
