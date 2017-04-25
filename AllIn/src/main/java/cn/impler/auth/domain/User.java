package cn.impler.auth.domain;

import cn.impler.auth.dto.UserIdentityEnum;

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
	private String mobileNum;
	// email address
	private String emailAddress;
	// identity
	private UserIdentityEnum identity;

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

	public String getMobileNum() {
		return mobileNum;
	}

	public void setMobileNum(String mobileNum) {
		this.mobileNum = mobileNum;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public UserIdentityEnum getIdentity() {
		return identity;
	}

	public void setIdentity(UserIdentityEnum identity) {
		this.identity = identity;
	}
	
	public boolean isAdmin(){
		return UserIdentityEnum.ADMIN.equals(this.identity);
	}

}
