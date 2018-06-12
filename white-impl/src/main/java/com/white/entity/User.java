package com.white.entity;

import com.white.common.WhiteConstants;
import com.white.enums.CommonEnums;

import javax.persistence.*;
import java.util.Date;

/**
 * 用户基本信息类
 *
 * @author: White
 * @date: 2018/5/4
 */
@Entity
@Table(name = "T_USER", schema = WhiteConstants.DB_SCHEMA_NAME)
public class User extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_ID")
    private Long userId;
    /**用户代码*/
    @Column(name = "USER_CODE", length = 20)
    private String userCode;
    /**用户中文名*/
    @Column(name = "USER_NAME_CN", length = 200)
    private String userNameCn;
    /**用户英文名*/
    @Column(name = "USER_NAME_EN", length = 200)
    private String userNameEn;
    /**密码*/
    @Column(name = "PASSWORD", length = 300)
    private String password;
    /**出生日期*/
    @Column(name = "BIRTH")
    @Temporal(TemporalType.DATE)
    private Date birth;
    /**邮箱*/
    @Column(name = "EMAIL", length = 100)
    private String email;
    /**地址*/
    @Column(name = "ADDRESS", length = 500)
    private String address;
    /**联系方式*/
    @Column(name = "PHONE", length = 20)
    private String phone;
    /**锁定状态*/
    @Column(name = "LOCKED")
    @Enumerated(EnumType.STRING)
    private CommonEnums.IF locked;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getUserNameCn() {
        return userNameCn;
    }

    public void setUserNameCn(String userNameCn) {
        this.userNameCn = userNameCn;
    }

    public String getUserNameEn() {
        return userNameEn;
    }

    public void setUserNameEn(String userNameEn) {
        this.userNameEn = userNameEn;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public CommonEnums.IF getLocked() {
        return locked;
    }

    public void setLocked(CommonEnums.IF locked) {
        this.locked = locked;
    }
}
