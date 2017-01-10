package cn.impler.auth.domain;

public class User extends BaseDomain{

	// 用户名
	private String username;
	// 昵称
	private String nickname;
	// 密码
	private String password;
	// 密码盐值
	private String salt;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

}
