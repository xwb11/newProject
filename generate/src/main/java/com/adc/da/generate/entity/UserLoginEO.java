package com.adc.da.generate.entity;

import com.adc.da.base.entity.BaseEntity;


/**
 * <b>功能：</b>TS_USER_LOGIN UserLoginEOEntity<br>
 * <b>作者：</b>code generator<br>
 * <b>日期：</b> 2018-09-11 <br>
 * <b>版权所有：<b>版权归北京卡达克数据技术中心所有。<br>
 */
public class UserLoginEO extends BaseEntity {

    private Integer pkLogin;
    private String name;
    private String password;

    /**
     * java字段名转换为原始数据库列名。<b>如果不存在则返回null</b><br>
     * <p>字段列表：</p>
     * <li>pkLogin -> pk_login</li>
     * <li>name -> name</li>
     * <li>password -> password</li>
     */
    public static String fieldToColumn(String fieldName) {
        if (fieldName == null) return null;
        switch (fieldName) {
            case "pkLogin": return "pk_login";
            case "name": return "name";
            case "password": return "password";
            default: return null;
        }
    }

    /**
     * 原始数据库列名转换为java字段名。<b>如果不存在则返回null</b><br>
     * <p>字段列表：</p>
     * <li>pk_login -> pkLogin</li>
     * <li>name -> name</li>
     * <li>password -> password</li>
     */
    public static String columnToField(String columnName) {
        if (columnName == null) return null;
        switch (columnName) {
            case "pk_login": return "pkLogin";
            case "name": return "name";
            case "password": return "password";
            default: return null;
        }
    }
    
    /**  **/
    public Integer getPkLogin() {
        return this.pkLogin;
    }

    /**  **/
    public void setPkLogin(Integer pkLogin) {
        this.pkLogin = pkLogin;
    }

    /**  **/
    public String getName() {
        return this.name;
    }

    /**  **/
    public void setName(String name) {
        this.name = name;
    }

    /**  **/
    public String getPassword() {
        return this.password;
    }

    /**  **/
    public void setPassword(String password) {
        this.password = password;
    }

}
