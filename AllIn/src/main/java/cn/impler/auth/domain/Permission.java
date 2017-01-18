package cn.impler.auth.domain;

import cn.impler.auth.dto.RequestMethodType;

public class Permission extends BaseDomain {

	// permission name
	private String name;

	// permission level
	private int level;

	// permission path
	private String path;

	// permission type
	private RequestMethodType type = RequestMethodType.ALL;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public RequestMethodType getType() {
		return type;
	}

	public void setType(RequestMethodType type) {
		this.type = type;
	}

}
