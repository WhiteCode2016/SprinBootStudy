package com.white.dto;

import com.white.enums.CommonEnums;

import java.io.Serializable;

/**
 * All rights Reserved, Designed by xxxx
 *
 * @author: White
 * @date: 2018/6/11
 */
public class UserQueryDTO implements Serializable {
    private String userCode;
    private String userName;
    private CommonEnums.IF locked;

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public CommonEnums.IF getLocked() {
        return locked;
    }

    public void setLocked(CommonEnums.IF locked) {
        this.locked = locked;
    }
}
