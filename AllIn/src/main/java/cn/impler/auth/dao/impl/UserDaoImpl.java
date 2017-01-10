package cn.impler.auth.dao.impl;

import org.springframework.stereotype.Repository;

import cn.impler.auth.dao.UserDao;
import cn.impler.auth.domain.User;
import cn.impler.framework.mybatis.dao.intf.AbstractDao;

@Repository("userDao")
public class UserDaoImpl extends 
		AbstractDao<UserDao, User, Integer> implements
		UserDao {

}
