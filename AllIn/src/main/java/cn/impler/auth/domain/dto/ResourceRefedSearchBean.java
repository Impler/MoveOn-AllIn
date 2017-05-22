package cn.impler.auth.domain.dto;

import cn.impler.auth.domain.User;
import cn.impler.auth.dto.ResourceLevelEnum;
import cn.impler.auth.dto.ResourceTypeEnum;

public class ResourceRefedSearchBean {

	// resource type
	private ResourceTypeEnum type;

	// resource level
	private ResourceLevelEnum level;

	// resource owner
	private User owner;

	// parent id
	private Integer parentId;

	public ResourceLevelEnum getLevel() {
		return level;
	}

	public void setLevel(ResourceLevelEnum level) {
		this.level = level;
	}

	public ResourceTypeEnum getType() {
		return type;
	}

	public void setType(ResourceTypeEnum type) {
		this.type = type;
	}

	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}

	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

}
