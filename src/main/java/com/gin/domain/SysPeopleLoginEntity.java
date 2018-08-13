package com.gin.domain;

import java.io.Serializable;

/**
 * code is far away from bug with the animal protecting
 * ┏┓　　   ┏┓
 * ┏┛┻━━━━━━┛┻┓
 * ┃　　　　　　┃
 * ┃　　━　    ┃
 * ┃　┳┛　┗┳   ┃
 * ┃　　　　　　┃
 * ┃　　┻　　　 ┃
 * ┃　　　　　　┃
 * ┗━┓　　 ┏━━━┛
 * 　┃　　　┃神兽保佑
 * 　┃　　　┃代码无BUG！
 * 　┃　　　┗━━━┓
 * 　┃　　　　　 ┣┓
 * 　┃　　　　　┏┛
 * 　┗┓┓┏━━┳┓┏┛
 * 　 ┃┫┫　┃┫┫
 * 　 ┗┻┛　┗┻┛
 * Created by Jean .
 * 2018/8/13
 */
public class SysPeopleLoginEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    private String ehrId;
    private String password;
    private String clientId;
    private String sessionId;
    private String loginType;
    private String loginTime;
    private String timeoutTime;
    private String loginStatus;
    private int loginCount;
    private String createTime;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getEhrId() {
        return ehrId;
    }

    public void setEhrId(String ehrId) {
        this.ehrId = ehrId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getLoginType() {
        return loginType;
    }

    public void setLoginType(String loginType) {
        this.loginType = loginType;
    }

    public String getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(String loginTime) {
        this.loginTime = loginTime;
    }

    public String getTimeoutTime() {
        return timeoutTime;
    }

    public void setTimeoutTime(String timeoutTime) {
        this.timeoutTime = timeoutTime;
    }

    public String getLoginStatus() {
        return loginStatus;
    }

    public void setLoginStatus(String loginStatus) {
        this.loginStatus = loginStatus;
    }

    public int getLoginCount() {
        return loginCount;
    }

    public void setLoginCount(int loginCount) {
        this.loginCount = loginCount;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "SysPeopleLoginEntity{" +
                "ehrId='" + ehrId + '\'' +
                ", password='" + password + '\'' +
                ", clientId='" + clientId + '\'' +
                ", sessionId='" + sessionId + '\'' +
                ", loginType='" + loginType + '\'' +
                ", loginTime='" + loginTime + '\'' +
                ", timeoutTime='" + timeoutTime + '\'' +
                ", loginStatus='" + loginStatus + '\'' +
                ", loginCount=" + loginCount +
                ", createTime='" + createTime + '\'' +
                '}';
    }

}
