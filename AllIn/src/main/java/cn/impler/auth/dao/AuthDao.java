package cn.impler.auth.dao;

import java.util.List;

import cn.impler.framework.mybatis.dao.dto.Pagination;
import cn.impler.framework.mybatis.dao.intf.BaseDao;

/**
 * a extension of BaseDao, which defines many specific scene functions
 * @author impler
 * @date 2017-01-11
 * @param <E> entity class
 * @param <K> entity key
 * @param <S> entity search key word
 */
public interface AuthDao<E, K, S> extends BaseDao<E, K> {

	/**
	 * query in pagination
	 * @param search
	 * @param page
	 * @return
	 */
	List<E> selectInPagination(S search, Pagination page);
}
