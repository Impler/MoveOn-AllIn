package cn.impler.auth.dao.impl;

import org.springframework.stereotype.Repository;

import cn.impler.auth.dao.AbsAuthDao;
import cn.impler.auth.dao.LoginDetailDao;
import cn.impler.auth.domain.LoginDetail;

@Repository
public class LoginDetailDaoImpl extends AbsAuthDao<LoginDetailDao, LoginDetail, Integer, LoginDetail>
        implements LoginDetailDao {
}
