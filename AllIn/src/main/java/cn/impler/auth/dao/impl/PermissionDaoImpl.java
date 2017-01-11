package cn.impler.auth.dao.impl;

import org.springframework.stereotype.Repository;

import cn.impler.auth.dao.AbsAuthDao;
import cn.impler.auth.dao.PermissionDao;
import cn.impler.auth.domain.Permission;
import cn.impler.auth.domain.dto.PermissionSearchBean;

/**
 * permission dao implement
 * @author impler
 * @date 2017-01-11
 */
@Repository("permissionDao")
public class PermissionDaoImpl extends
		AbsAuthDao<PermissionDao, Permission, Integer, PermissionSearchBean> implements
		PermissionDao {

}
