package cn.impler.auth.service;

import java.util.List;

import cn.impler.auth.dao.AuthDao;
import cn.impler.framework.mybatis.dao.dto.Pagination;

/**
 * a basic implement of AuthService
 * @author impler
 * @date 2017-01-11
 * @param <E>
 * @param <K>
 * @param <S>
 */
public abstract class AbsAuthService<E, K, S> 
		implements AuthService<E, K, S> {

	/**
	 * a abstract function, which depends on sub-class' implement
	 * and return the actual AuthDao implements
	 * @return
	 */
	protected abstract AuthDao<E, K, S> getAuthDao();

	@Override
	public int add(E e) {
		return this.getAuthDao().insert(e);
	}


	@Override
	public List<E> selectInPagination(S search, Pagination page) {
		return this.getAuthDao().selectInPagination(search, page);
	}

	@Override
	public int deleteById(K id) {
		return this.getAuthDao().delete(id);
	}


	
	
	
}
