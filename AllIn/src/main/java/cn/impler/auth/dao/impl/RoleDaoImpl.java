package cn.impler.auth.dao.impl;

import org.springframework.stereotype.Repository;

import cn.impler.auth.dao.AbsAuthDao;
import cn.impler.auth.dao.RoleDao;
import cn.impler.auth.domain.Role;
import cn.impler.auth.domain.dto.RoleSearchBean;

/**
 * role dao implement
 * @author impler
 * @date 2017-01-11
 */
@Repository("roleDao")
public class RoleDaoImpl extends 
		AbsAuthDao<RoleDao, Role, Integer, RoleSearchBean> implements
		RoleDao {

}
