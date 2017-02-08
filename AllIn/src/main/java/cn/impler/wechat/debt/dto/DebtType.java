package cn.impler.wechat.debt.dto;

import cn.impler.framework.mybatis.dao.dto.IGenericEnum;

/**
 * debt type
 * @author impler
 * @date 2017-02-08
 */
public enum DebtType implements IGenericEnum{

	// borrow money
	IN(1), 
	// lend money
	OUT(2);
	
	private int id;
	
	private DebtType(int id) {
		this.id = id;
	}

	@Override
	public int getId() {
		return this.id;
	}

}
