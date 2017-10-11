package cn.impler.auth.service.impl;

import java.util.Date;

import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.impler.auth.dao.AuthDao;
import cn.impler.auth.dao.LoginDetailDao;
import cn.impler.auth.dao.UserDao;
import cn.impler.auth.domain.LoginDetail;
import cn.impler.auth.domain.User;
import cn.impler.auth.domain.dto.UserSearchBean;
import cn.impler.auth.service.AbsAuthService;
import cn.impler.auth.service.UserService;
import cn.impler.auth.util.SecurityUtil;
import cn.impler.common.util.RegexUtil;

/**
 * user service implement
 * 
 * @author impler
 * @date 2017-01-11
 */
@Service("userService")
public class UserServiceImpl extends
		AbsAuthService<User, Integer, UserSearchBean> implements UserService {

    private static final int MAX_FAILED_TIMES = 5;

    // default locked time is 60s
    private long lockedTime = 60000;
    
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private LoginDetailDao loginDetailDao;
	
	@Override
	protected AuthDao<User, Integer, UserSearchBean> getAuthDao() {
		return userDao;
	}

	/**
	 * TODO
	 * users' password should be set by themselves
	 */
	@Override
	public int add(User e) {
		SimpleHash simpleHash = SecurityUtil.encryptPassword(e.getPassword());
		e.setSalt(simpleHash.getSalt().toString());
		e.setPassword(simpleHash.toString());
		return super.add(e);
	}



	@Override
	@Cacheable(value="userSecurityInfo", key="#username")
	public User querySecurityInfoByUsername(String username) {
		User user = userDao.querySecurityInfoByUsername(username);

		if (null == user && RegexUtil.isMobileNumStr(username)) {
			user = userDao.querySecurityInfoByMobileNum(username);
		}
		if (null == user && RegexUtil.isEmailAddressStr(username)) {
			user = userDao.querySecurityInfoByEmailAddress(username);
		}
		
		return user;
	}

	/**
	 * validate user locked status、active status、close status（销户）
	 * @param user
	 */
	@Override
	public void checkUserStatus(User user) {
	    if (null == user) {
            throw new UnknownAccountException();
        }
	    if(!user.isActive()){
	        throw new DisabledAccountException();
	    }
	    if(user.isLocked()){
	        Date lockedTime = user.getLockedTime();
	        // default locked time is 10min
            if (new Date().before(new Date(lockedTime.getTime() + this.lockedTime))) {
                throw new LockedAccountException();
            }
	    }
	    // TODO any other validation
    }

    @Override
	public User queryCommonInfoByUsername(String username) {
		User user = userDao.queryCommonInfoByUsername(username);

		if (null == user && RegexUtil.isMobileNumStr(username)) {
			user = userDao.queryCommonInfoByMobileNum(username);
		}
		if (null == user && RegexUtil.isEmailAddressStr(username)) {
			user = userDao.queryCommonInfoByEmailAddress(username);
		}

		return user;
	}

    @Override
    @Transactional
    public void saveLoginDetail(User user, LoginDetail detail) {
        loginDetailDao.insert(detail);
        if(!detail.isSuccess()){
            int failedTimes = user.getLoginFailedTimes();
            failedTimes++;
            if(failedTimes >= MAX_FAILED_TIMES){
                user.setLocked(true);
            }
            user.setLoginFailedTimes(failedTimes);
            user.setLockedTime(new Date());
        }else{
            user.setLocked(false);
            user.setLoginFailedTimes(0);
            user.setLockedTime(null);
        }
        userDao.updateLockedStatus(user);
    }


}
