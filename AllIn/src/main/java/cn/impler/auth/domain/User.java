package cn.impler.auth.domain;

public class User extends BaseDomain {

	// username
	private String username;
	// nickname
	private String nickname;
	// password
	private String password;
	// password salt
	private String salt;
	// mobile number
	private String mobielNum;
	// email address
	private String emailAddress;

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

	public String getMobielNum() {
		return mobielNum;
	}

	public void setMobielNum(String mobielNum) {
		this.mobielNum = mobielNum;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

}
