package cn.impler.auth.dto;

import cn.impler.framework.mybatis.dao.dto.IGenericEnum;

/**
 * resource url type
 * @author impler
 * @date 2017-04-21
 */
public enum ResourceUrlStyleEnum implements IGenericEnum{

	LITERAL(1), ANT(2);
	
	private int id;
	
	private ResourceUrlStyleEnum(int id) {
		this.id = id;
	}

	@Override
	public int getId() {
		return this.id;
	}

}
