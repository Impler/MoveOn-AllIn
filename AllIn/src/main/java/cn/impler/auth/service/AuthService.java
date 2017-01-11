package cn.impler.auth.service;

import java.util.List;

import cn.impler.framework.mybatis.dao.dto.Pagination;

/**
 * a universal service interface
 * @author impler
 * @date 2017-01-10
 * @param <E> entity class
 * @param <K> entity key
 * @param <S> entity search class
 */
public interface AuthService<E, K, S> {
	
	/**
	 * create a entity
	 * @param e
	 * @return
	 */
	int add(E e);

	/**
	 * query in pagination
	 * @param search query key word
	 * @param page pagination information
	 * @return
	 */
	List<E> selectInPagination(S search, Pagination page);

	/**
	 * delete a entity by id
	 * @param id
	 * @return
	 */
	int deleteById(K id);
}
