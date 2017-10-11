package cn.impler.auth.domain;

public class LoginDetail extends BaseDomain {

    private static final long serialVersionUID = -6912217194354990668L;
    public static final String LOGIN_STATUS_SUCCESS = "1";
    public static final String LOGIN_STATUS_FAILURE = "0";
    // login username
    private String username;
    private Integer userId;
    // login ip
    private String ip;
    // login device
    private String device;
    // login final status: success or failure
    private String loginStatus;
    // exception of login failure
    private String loginException;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getLoginStatus() {
        return loginStatus;
    }

    public void setLoginStatus(String loginStatus) {
        this.loginStatus = loginStatus;
    }

    public String getLoginException() {
        return loginException;
    }

    public void setLoginException(String loginException) {
        this.loginException = loginException;
    }

    public String getDevice() {
        return device;
    }

    public void setDevice(String device) {
        this.device = device;
    }

    public boolean isSuccess(){
        return LOGIN_STATUS_SUCCESS.equals(this.loginStatus);
    }
}
