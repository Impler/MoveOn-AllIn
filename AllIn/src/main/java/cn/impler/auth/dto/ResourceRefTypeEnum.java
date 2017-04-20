package cn.impler.auth.dto;

import cn.impler.framework.mybatis.dao.dto.IGenericEnum;

public enum ResourceRefTypeEnum implements IGenericEnum {

	USERROLE(1), 
	ROLERESOURCE(2);
	
	// key
	private int id;
	
	private ResourceRefTypeEnum(int id) {
		this.id = id;
	}

	@Override
	public int getId() {
		return this.id;
	}

}
