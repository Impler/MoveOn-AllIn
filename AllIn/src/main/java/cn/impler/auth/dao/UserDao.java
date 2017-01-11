package cn.impler.auth.dao;

import cn.impler.auth.domain.User;
import cn.impler.auth.domain.dto.UserSearchBean;

/**
 * user dao
 * @author impler
 * @date 2017-01-11
 */
public interface UserDao extends AuthDao<User, Integer, UserSearchBean> {

}
