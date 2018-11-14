package com.adc.da.generate.page;

import com.adc.da.base.page.BasePage;


/**
 * <b>功能：</b>USERLOGIN UserloginEOPage<br>
 * <b>作者：</b>code generator<br>
 * <b>日期：</b> 2018-11-11 <br>
 * <b>版权所有：<b>版权归北京卡达克数据技术中心所有。<br>
 */
public class UserloginEOPage extends BasePage {

    private String userKey;
    private String userKeyOperator = "=";
    private String userRole;
    private String userRoleOperator = "=";
    private String account;
    private String accountOperator = "=";
    private String password;
    private String passwordOperator = "=";
    private String realname = "=";
    private String realnameOperator = "=";

    public String getUserKey() {
        return this.userKey;
    }

    public void setUserKey(String userKey) {
        this.userKey = userKey;
    }

    public String getUserKeyOperator() {
        return this.userKeyOperator;
    }

    public void setUserKeyOperator(String userKeyOperator) {
        this.userKeyOperator = userKeyOperator;
    }

    public String getUserRole() {
        return this.userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    public String getUserRoleOperator() {
        return this.userRoleOperator;
    }

    public void setUserRoleOperator(String userRoleOperator) {
        this.userRoleOperator = userRoleOperator;
    }

    public String getAccount() {
        return this.account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getAccountOperator() {
        return this.accountOperator;
    }

    public void setAccountOperator(String accountOperator) {
        this.accountOperator = accountOperator;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordOperator() {
        return this.passwordOperator;
    }

    public void setPasswordOperator(String passwordOperator) {
        this.passwordOperator = passwordOperator;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getRealnameOperator() {
        return realnameOperator;
    }

    public void setRealnameOperator(String realnameOperator) {
        this.realnameOperator = realnameOperator;
    }
}
