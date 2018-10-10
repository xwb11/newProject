package com.adc.da.generate.entity;

import com.adc.da.base.entity.BaseEntity;

import java.util.Date;

/**
 * <b>功能：</b>USERINFORMATION UserinformationEOEntity<br>
 * <b>作者：</b>code generator<br>
 * <b>日期：</b> 2018-10-08 <br>
 * <b>版权所有：<b>版权归北京卡达克数据技术中心所有。<br>
 */
public class UserinformationEO extends BaseEntity {

    private String userkey;
    private String useraccount;
    private String userpassword;
    private String userrole;
    @org.springframework.format.annotation.DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date createtime;

    /**
     * java字段名转换为原始数据库列名。<b>如果不存在则返回null</b><br>
     * <p>字段列表：</p>
     * <li>userkey -> userkey</li>
     * <li>useraccount -> useraccount</li>
     * <li>userpassword -> userpassword</li>
     * <li>userrole -> userrole</li>
     * <li>createtime -> createtime</li>
     */
    public static String fieldToColumn(String fieldName) {
        if (fieldName == null) return null;
        switch (fieldName) {
            case "userkey": return "userkey";
            case "useraccount": return "useraccount";
            case "userpassword": return "userpassword";
            case "userrole": return "userrole";
            case "createtime": return "createtime";
            default: return null;
        }
    }

    /**
     * 原始数据库列名转换为java字段名。<b>如果不存在则返回null</b><br>
     * <p>字段列表：</p>
     * <li>userkey -> userkey</li>
     * <li>useraccount -> useraccount</li>
     * <li>userpassword -> userpassword</li>
     * <li>userrole -> userrole</li>
     * <li>createtime -> createtime</li>
     */
    public static String columnToField(String columnName) {
        if (columnName == null) return null;
        switch (columnName) {
            case "userkey": return "userkey";
            case "useraccount": return "useraccount";
            case "userpassword": return "userpassword";
            case "userrole": return "userrole";
            case "createtime": return "createtime";
            default: return null;
        }
    }
    
    /**  **/
    public String getUserkey() {
        return this.userkey;
    }

    /**  **/
    public void setUserkey(String userkey) {
        this.userkey = userkey;
    }

    /**  **/
    public String getUseraccount() {
        return this.useraccount;
    }

    /**  **/
    public void setUseraccount(String useraccount) {
        this.useraccount = useraccount;
    }

    /**  **/
    public String getUserpassword() {
        return this.userpassword;
    }

    /**  **/
    public void setUserpassword(String userpassword) {
        this.userpassword = userpassword;
    }

    /**  **/
    public String getUserrole() {
        return this.userrole;
    }

    /**  **/
    public void setUserrole(String userrole) {
        this.userrole = userrole;
    }

    /**  **/
    public Date getCreatetime() {
        return this.createtime;
    }

    /**  **/
    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

}
