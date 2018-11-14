package com.adc.da.generate.entity;

import com.adc.da.base.entity.BaseEntity;


/**
 * <b>功能：</b>RECRUITPEOPLE RecruitpeopleEOEntity<br>
 * <b>作者：</b>code generator<br>
 * <b>日期：</b> 2018-11-08 <br>
 * <b>版权所有：<b>版权归北京卡达克数据技术中心所有。<br>
 */
public class RecruitpeopleEO extends BaseEntity {

    private String projectKey;
    private String userKey;
    private String userAccount;
    private String userPassword;
    private String userRole;
    private String status;
    private String mail;
    private Long phone;
    private String realname;
    private String location;
    private Long qqnumber;

    /**
     * java字段名转换为原始数据库列名。<b>如果不存在则返回null</b><br>
     * <p>字段列表：</p>
     * <li>projectKey -> project_key</li>
     * <li>userKey -> user_key</li>
     * <li>userAccount -> user_account</li>
     * <li>userPassword -> user_password</li>
     * <li>userRole -> user_role</li>
     * <li>status -> status</li>
     * <li>mail -> mail</li>
     * <li>phone -> phone</li>
     * <li>realname -> realname</li>
     * <li>location -> location</li>
     * <li>qqnumber -> qqnumber</li>
     */
    public static String fieldToColumn(String fieldName) {
        if (fieldName == null) return null;
        switch (fieldName) {
            case "projectKey": return "project_key";
            case "userKey": return "user_key";
            case "userAccount": return "user_account";
            case "userPassword": return "user_password";
            case "userRole": return "user_role";
            case "status": return "status";
            case "mail": return "mail";
            case "phone": return "phone";
            case "realname": return "realname";
            case "location": return "location";
            case "qqnumber": return "qqnumber";
            default: return null;
        }
    }

    /**
     * 原始数据库列名转换为java字段名。<b>如果不存在则返回null</b><br>
     * <p>字段列表：</p>
     * <li>project_key -> projectKey</li>
     * <li>user_key -> userKey</li>
     * <li>user_account -> userAccount</li>
     * <li>user_password -> userPassword</li>
     * <li>user_role -> userRole</li>
     * <li>status -> status</li>
     * <li>mail -> mail</li>
     * <li>phone -> phone</li>
     * <li>realname -> realname</li>
     * <li>location -> location</li>
     * <li>qqnumber -> qqnumber</li>
     */
    public static String columnToField(String columnName) {
        if (columnName == null) return null;
        switch (columnName) {
            case "project_key": return "projectKey";
            case "user_key": return "userKey";
            case "user_account": return "userAccount";
            case "user_password": return "userPassword";
            case "user_role": return "userRole";
            case "status": return "status";
            case "mail": return "mail";
            case "phone": return "phone";
            case "realname": return "realname";
            case "location": return "location";
            case "qqnumber": return "qqnumber";
            default: return null;
        }
    }
    
    /**  **/
    public String getProjectKey() {
        return this.projectKey;
    }

    /**  **/
    public void setProjectKey(String projectKey) {
        this.projectKey = projectKey;
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
    public String getUserAccount() {
        return this.userAccount;
    }

    /**  **/
    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }

    /**  **/
    public String getUserPassword() {
        return this.userPassword;
    }

    /**  **/
    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
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
    public String getStatus() {
        return this.status;
    }

    /**  **/
    public void setStatus(String status) {
        this.status = status;
    }

    /**  **/
    public String getMail() {
        return this.mail;
    }

    /**  **/
    public void setMail(String mail) {
        this.mail = mail;
    }

    /**  **/
    public Long getPhone() {
        return this.phone;
    }

    /**  **/
    public void setPhone(Long phone) {
        this.phone = phone;
    }

    /**  **/
    public String getRealname() {
        return this.realname;
    }

    /**  **/
    public void setRealname(String realname) {
        this.realname = realname;
    }

    /**  **/
    public String getLocation() {
        return this.location;
    }

    /**  **/
    public void setLocation(String location) {
        this.location = location;
    }

    /**  **/
    public Long getQqnumber() {
        return this.qqnumber;
    }

    /**  **/
    public void setQqnumber(Long qqnumber) {
        this.qqnumber = qqnumber;
    }

}
