package cn.impler.auth.service;

import cn.impler.auth.domain.User;
import cn.impler.auth.domain.dto.UserSearchBean;

/**
 * user service
 * @author impler
 * @date 2017-01-11
 */
public interface UserService 
		extends AuthService<User, Integer, UserSearchBean>{

}
