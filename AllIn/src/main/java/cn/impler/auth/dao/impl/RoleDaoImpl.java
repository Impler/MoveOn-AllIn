package cn.impler.auth.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.impler.auth.dao.AbsAuthDao;
import cn.impler.auth.dao.RoleDao;
import cn.impler.auth.domain.Role;
import cn.impler.auth.domain.dto.RoleSearchBean;
import cn.impler.framework.mybatis.dao.dto.Pagination;
import cn.impler.framework.mybatis.dao.plugin.PaginationUtil;

/**
 * role dao implement
 * @author impler
 * @date 2017-01-11
 */
@Repository("roleDao")
public class RoleDaoImpl extends 
		AbsAuthDao<RoleDao, Role, Integer, RoleSearchBean> implements
		RoleDao {

	@Override
	public List<Role> selectInPagination(RoleSearchBean search, Pagination page) {
		String pageStmtId = "selectByPagination";
		String countStmtId = "selectByPaginationCount";
		return PaginationUtil.selectByPagination(super.getSqlSession(), pageStmtId, countStmtId, search, page);
	}

}
