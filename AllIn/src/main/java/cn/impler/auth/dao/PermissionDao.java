package cn.impler.auth.dao;

import cn.impler.auth.domain.Permission;
import cn.impler.auth.domain.dto.PermissionSearchBean;

/**
 * permission dao
 * @author impler
 * @date 2017-01-11
 */
public interface PermissionDao extends AuthDao<Permission, Integer, PermissionSearchBean> {

}
