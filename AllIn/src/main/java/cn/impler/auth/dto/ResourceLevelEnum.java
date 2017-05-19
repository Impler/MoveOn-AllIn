package cn.impler.auth.dto;

import cn.impler.framework.mybatis.dao.dto.IGenericEnum;

/**
 * resource level enum
 * 
 * @author impler
 * @date 2017-05-19
 */
public enum ResourceLevelEnum implements IGenericEnum {

	L1(1), L2(2), L3(3);

	private int id;

	private ResourceLevelEnum(int id) {
		this.id = id;
	}

	@Override
	public int getId() {
		return id;
	}
}