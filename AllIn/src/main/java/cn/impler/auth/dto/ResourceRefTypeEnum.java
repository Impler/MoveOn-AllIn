package cn.impler.auth.dto;

import cn.impler.framework.mybatis.dao.dto.IGenericEnum;

public enum ResourceRefTypeEnum implements IGenericEnum {

	USERROLE(1), 
	ROLEMENU(2),
	MENUURL(3);
	
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
