package cn.impler.wechat.debt.dto;

import cn.impler.framework.mybatis.dao.dto.IGenericEnum;

/**
 * Borrowed and loan out channel
 * @author impler
 * @date 2017-02-08
 */
public enum DebtChannel implements IGenericEnum {

	// in cash
	CASH(1), 
	// by bank transfer
	BANKTRANSFER(2), 
	// by alipay transfer
	ALIPAY(3), 
	// by wechat transfer
	WECHAT(4);

	private int id;

	private DebtChannel(int id) {
		this.id = id;
	}

	@Override
	public int getId() {
		return this.id;
	}

}
