package cn.impler.auth.domain;

public class Role extends BaseDomain {

	// 角色名称
	private String name;

	// 角色描述
	private String description;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
