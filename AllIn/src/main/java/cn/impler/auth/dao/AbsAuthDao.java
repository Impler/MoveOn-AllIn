package cn.impler.auth.dao;

import java.util.List;

import cn.impler.framework.mybatis.dao.dto.Pagination;
import cn.impler.framework.mybatis.dao.intf.AbstractDao;
import cn.impler.framework.mybatis.dao.plugin.PaginationUtil;

/**
 * a basic implement of AuthDao
 * @author impler
 * @date 2017-01-11
 * @param <D> dao interface class
 * @param <E> entity class
 * @param <K> entity key
 * @param <S> entity search key word
 */
public abstract class AbsAuthDao<D extends AuthDao<E, K, S>, E, K, S> 
		extends AbstractDao<D, E, K> 
		implements AuthDao<E, K, S>{

	@Override
	public List<E> selectInPagination(S search, Pagination page) {
		String pageStmtId = "selectByPagination";
		String countStmtId = "selectByPaginationCount";
		return PaginationUtil.selectByPagination(super.getSqlSession(), pageStmtId, countStmtId, search, page);
	}

	
	
}
