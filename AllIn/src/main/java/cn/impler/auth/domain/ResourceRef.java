package cn.impler.auth.domain;

import cn.impler.auth.dto.ResourceRefTypeEnum;

public class ResourceRef extends BaseDomain {

	// key
	private int leftVal;
	// references
	private int rightVal;
	// type
	private ResourceRefTypeEnum type;

	public int getLeftVal() {
		return leftVal;
	}

	public void setLeftVal(int leftVal) {
		this.leftVal = leftVal;
	}

	public int getRightVal() {
		return rightVal;
	}

	public void setRightVal(int rightVal) {
		this.rightVal = rightVal;
	}

	public ResourceRefTypeEnum getType() {
		return type;
	}

	public void setType(ResourceRefTypeEnum type) {
		this.type = type;
	}
}
