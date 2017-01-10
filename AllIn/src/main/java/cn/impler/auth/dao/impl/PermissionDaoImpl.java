package cn.impler.auth.dao.impl;

import org.springframework.stereotype.Repository;

import cn.impler.auth.dao.PermissionDao;
import cn.impler.auth.domain.Permission;
import cn.impler.framework.mybatis.dao.intf.AbstractDao;

@Repository("permissionDao")
public class PermissionDaoImpl extends
		AbstractDao<PermissionDao, Permission, Integer> implements
		PermissionDao {

}
