package cn.impler.auth.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.impler.auth.dao.RoleDao;
import cn.impler.auth.domain.Role;
import cn.impler.auth.domain.dto.RoleSearchBean;
import cn.impler.framework.mybatis.dao.dto.Pagination;
import cn.impler.framework.mybatis.dao.intf.AbstractDao;
import cn.impler.framework.mybatis.dao.plugin.PaginationUtil;

@Repository("roleDao")
public class RoleDaoImpl extends 
		AbstractDao<RoleDao, Role, Integer> implements
		RoleDao {

	@Override
	public List<Role> selectInPagination(RoleSearchBean search, Pagination page) {
		String pageStmtId = "selectByPagination";
		String countStmtId = "selectByPaginationCount";
		return PaginationUtil.selectByPagination(super.getSqlSession(), pageStmtId, countStmtId, search, page);
	}

}
