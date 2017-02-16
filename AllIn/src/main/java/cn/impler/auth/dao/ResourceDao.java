package cn.impler.auth.dao;

import cn.impler.auth.domain.Resource;
import cn.impler.auth.domain.dto.ResourceSearchBean;

/**
 * resource dao
 * @author impler
 * @date 2017-02-16
 */
public interface ResourceDao extends AuthDao<Resource, Integer, ResourceSearchBean> {

}
