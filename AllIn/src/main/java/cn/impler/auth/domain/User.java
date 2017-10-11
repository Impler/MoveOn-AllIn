package cn.impler.auth.domain;

import java.util.Date;

import cn.impler.auth.dto.UserIdentityEnum;

public class User extends BaseDomain {

    private static final long serialVersionUID = 670192719661223211L;

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

    // login failed times
    private int loginFailedTimes;
    // is locked
    private boolean isLocked;
    // locked time
    private Date lockedTime;
    // is active
    private boolean isActive;
    // create time
    private Date createTime;

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

    public boolean isAdmin() {
        return UserIdentityEnum.ADMIN.equals(this.identity);
    }

    public int getLoginFailedTimes() {
        return loginFailedTimes;
    }

    public void setLoginFailedTimes(int loginFailedTimes) {
        this.loginFailedTimes = loginFailedTimes;
    }

    public boolean isLocked() {
        return isLocked;
    }

    public void setLocked(boolean isLocked) {
        this.isLocked = isLocked;
    }

    public Date getLockedTime() {
        return lockedTime;
    }

    public void setLockedTime(Date lockedTime) {
        this.lockedTime = lockedTime;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean isActive) {
        this.isActive = isActive;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
