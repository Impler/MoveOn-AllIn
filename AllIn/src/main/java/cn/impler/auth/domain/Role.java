package cn.impler.auth.domain;

import javax.validation.constraints.NotNull;

public class Role extends BaseDomain {

    private static final long serialVersionUID = -1601772141550893776L;

    // role name
	@NotNull(message="{role.name}")
	private String name;

	// role description
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

	@Override
	public String toString() {
		return "Role [name=" + name + ", description=" + description + "]";
	}

}
