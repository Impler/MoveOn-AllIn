package cn.impler.auth.dao;

import java.util.List;

import cn.impler.auth.domain.Role;
import cn.impler.auth.domain.dto.RoleSearchBean;
import cn.impler.framework.mybatis.dao.dto.Pagination;
import cn.impler.framework.mybatis.dao.intf.BaseDao;

public interface RoleDao extends BaseDao<Role, Integer> {

	/**
	 * query roles in pagination
	 * @param search
	 * @param page
	 * @return
	 */
	List<Role> selectInPagination(RoleSearchBean search, Pagination page);

}
