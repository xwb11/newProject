package com.adc.da.generate.entity;

import com.adc.da.base.entity.BaseEntity;


/**
 * <b>功能：</b>USERLOGIN UserloginEOEntity<br>
 * <b>作者：</b>code generator<br>
 * <b>日期：</b> 2018-11-11 <br>
 * <b>版权所有：<b>版权归北京卡达克数据技术中心所有。<br>
 */
public class UserloginEO extends BaseEntity {

    private String userKey;
    private String userRole;
    private String account;
    private String password;
    private String realname;

    /**
     * java字段名转换为原始数据库列名。<b>如果不存在则返回null</b><br>
     * <p>字段列表：</p>
     * <li>userKey -> user_key</li>
     * <li>userRole -> user_role</li>
     * <li>account -> account</li>
     * <li>password -> password</li>
     */
    public static String fieldToColumn(String fieldName) {
        if (fieldName == null) return null;
        switch (fieldName) {
            case "userKey": return "user_key";
            case "userRole": return "user_role";
            case "account": return "account";
            case "password": return "password";
            case "realname": return "realname";
            default: return null;
        }
    }

    /**
     * 原始数据库列名转换为java字段名。<b>如果不存在则返回null</b><br>
     * <p>字段列表：</p>
     * <li>user_key -> userKey</li>
     * <li>user_role -> userRole</li>
     * <li>account -> account</li>
     * <li>password -> password</li>
     */
    public static String columnToField(String columnName) {
        if (columnName == null) return null;
        switch (columnName) {
            case "user_key": return "userKey";
            case "user_role": return "userRole";
            case "account": return "account";
            case "password": return "password";
            case "realname": return "realname";
            default: return null;
        }
    }
    
    /**  **/
    public String getUserKey() {
        return this.userKey;
    }

    /**  **/
    public void setUserKey(String userKey) {
        this.userKey = userKey;
    }

    /**  **/
    public String getUserRole() {
        return this.userRole;
    }

    /**  **/
    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    /**  **/
    public String getAccount() {
        return this.account;
    }

    /**  **/
    public void setAccount(String account) {
        this.account = account;
    }

    /**  **/
    public String getPassword() {
        return this.password;
    }

    /**  **/
    public void setPassword(String password) {
        this.password = password;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }
}
