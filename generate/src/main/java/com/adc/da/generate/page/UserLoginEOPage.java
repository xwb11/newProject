package com.adc.da.generate.page;

import com.adc.da.base.page.BasePage;


/**
 * <b>功能：</b>TS_USER_LOGIN UserLoginEOPage<br>
 * <b>作者：</b>code generator<br>
 * <b>日期：</b> 2018-09-11 <br>
 * <b>版权所有：<b>版权归北京卡达克数据技术中心所有。<br>
 */
public class UserLoginEOPage extends BasePage {

    private String pkLogin;
    private String pkLoginOperator = "=";
    private String name;
    private String nameOperator = "=";
    private String password;
    private String passwordOperator = "=";

    public String getPkLogin() {
        return this.pkLogin;
    }

    public void setPkLogin(String pkLogin) {
        this.pkLogin = pkLogin;
    }

    public String getPkLoginOperator() {
        return this.pkLoginOperator;
    }

    public void setPkLoginOperator(String pkLoginOperator) {
        this.pkLoginOperator = pkLoginOperator;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNameOperator() {
        return this.nameOperator;
    }

    public void setNameOperator(String nameOperator) {
        this.nameOperator = nameOperator;
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

}
