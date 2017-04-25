package cn.impler.auth.dto;

import cn.impler.framework.mybatis.dao.dto.IGenericEnum;

/**
 * user identity enum
 * @author impler
 * @date 2017-04-25
 */
public enum UserIdentityEnum implements IGenericEnum {

	ADMIN(1), USER(2);

	private UserIdentityEnum(int id) {
		this.id = id;
	}

	private int id;

	@Override
	public int getId() {
		return id;
	}

}
