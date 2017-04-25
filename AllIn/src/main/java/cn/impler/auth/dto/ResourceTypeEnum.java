package cn.impler.auth.dto;

import cn.impler.framework.mybatis.dao.dto.IGenericEnum;


public enum ResourceTypeEnum implements IGenericEnum{
	// menu resource
	MENU(1), 
	// link resource
	LINK(2);

	private int id;
	
	private ResourceTypeEnum(int id) {
		this.id = id;
	}

	@Override
	public int getId() {
		return this.id;
	}

	
}
