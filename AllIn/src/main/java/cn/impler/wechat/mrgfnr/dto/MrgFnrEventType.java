package cn.impler.wechat.mrgfnr.dto;

import cn.impler.framework.mybatis.dao.dto.IGenericEnum;

/**
 * event type
 * @author impler
 * @date 2016-11-333
 */
public enum MrgFnrEventType implements IGenericEnum {

	MARRIAGE(1), FUNERAL(2), HAVEKIDS(3);

	private int id;
	
	private MrgFnrEventType(int id){
		this.id = id;
	}
	
	@Override
	public int getId() {
		return this.id;
	}
}
