package cn.impler.auth.service;

import java.util.List;

import cn.impler.framework.mybatis.dao.dto.Pagination;

/**
 * 
 * @author impler
 * @date 2017-01-10
 * @param <E> entity class
 * @param <S> entity search class
 */
public interface AuthService<E, S> {
	
	int add(E role);

	/**
	 * query roles in pagination
	 * @param search query key word
	 * @param page pagination information
	 * @return
	 */
	List<E> selectInPagination(S search, Pagination page);
}
