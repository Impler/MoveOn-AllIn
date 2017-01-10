package cn.impler.auth.domain;

public class Permission extends BaseDomain {

	// 权限名称
	private String name;

	// 权限级别
	private int level;

	// 权限路径
	private String path;

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

}
