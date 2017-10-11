package cn.impler.auth.domain;

import cn.impler.auth.dto.ResourceRefTypeEnum;

public class ResourceRef<L extends BaseDomain, R extends BaseDomain> extends BaseDomain {

    private static final long serialVersionUID = 8711561411680275739L;
    
    // key
	private L leftVal;
	// references
	private R rightVal;
	// type
	private ResourceRefTypeEnum type;

	public L getLeftVal() {
		return leftVal;
	}

	public void setLeftVal(L leftVal) {
		this.leftVal = leftVal;
	}

	public R getRightVal() {
		return rightVal;
	}

	public void setRightVal(R rightVal) {
		this.rightVal = rightVal;
	}

	public ResourceRefTypeEnum getType() {
		return type;
	}

	public void setType(ResourceRefTypeEnum type) {
		this.type = type;
	}

}
