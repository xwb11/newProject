package com.adc.da.generate.entity;

import com.adc.da.base.entity.BaseEntity;

import java.util.Date;

/**
 * <b>功能：</b>SCHOOLINFORMATION SchoolinformationEOEntity<br>
 * <b>作者：</b>code generator<br>
 * <b>日期：</b> 2018-10-08 <br>
 * <b>版权所有：<b>版权归北京卡达克数据技术中心所有。<br>
 */
public class SchoolinformationEO extends BaseEntity {

    private String schoolkey;
    private String provincename;
    private String schoolname;
    private String briefintroduction;
    private String phone;
    private String address;
    @org.springframework.format.annotation.DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date createtime;



    /**
     * java字段名转换为原始数据库列名。<b>如果不存在则返回null</b><br>
     * <p>字段列表：</p>
     * <li>schoolkey -> schoolkey</li>
     * <li>provincename -> provincename</li>
     * <li>schoolname -> schoolname</li>
     * <li>briefintroduction -> briefintroduction</li>
     * <li>phone -> phone</li>
     * <li>address -> address</li>
     */
    public static String fieldToColumn(String fieldName) {
        if (fieldName == null) return null;
        switch (fieldName) {
            case "schoolkey": return "schoolkey";
            case "provincename": return "provincename";
            case "schoolname": return "schoolname";
            case "briefintroduction": return "briefintroduction";
            case "phone": return "phone";
            case "address": return "address";
            case "createtime": return "createtime";
            default: return null;
        }
    }

    /**
     * 原始数据库列名转换为java字段名。<b>如果不存在则返回null</b><br>
     * <p>字段列表：</p>
     * <li>schoolkey -> schoolkey</li>
     * <li>provincename -> provincename</li>
     * <li>schoolname -> schoolname</li>
     * <li>briefintroduction -> briefintroduction</li>
     * <li>phone -> phone</li>
     * <li>address -> address</li>
     */
    public static String columnToField(String columnName) {
        if (columnName == null) return null;
        switch (columnName) {
            case "schoolkey": return "schoolkey";
            case "provincename": return "provincename";
            case "schoolname": return "schoolname";
            case "briefintroduction": return "briefintroduction";
            case "phone": return "phone";
            case "address": return "address";
            case "createtime": return "createtime";
            default: return null;
        }
    }
    
    /**  **/
    public String getSchoolkey() {
        return this.schoolkey;
    }

    /**  **/
    public void setSchoolkey(String schoolkey) {
        this.schoolkey = schoolkey;
    }

    /**  **/
    public String getProvincename() {
        return this.provincename;
    }

    /**  **/
    public void setProvincename(String provincename) {
        this.provincename = provincename;
    }

    /**  **/
    public String getSchoolname() {
        return this.schoolname;
    }

    /**  **/
    public void setSchoolname(String schoolname) {
        this.schoolname = schoolname;
    }

    /**  **/
    public String getBriefintroduction() {
        return this.briefintroduction;
    }

    /**  **/
    public void setBriefintroduction(String briefintroduction) {
        this.briefintroduction = briefintroduction;
    }

    /**  **/
    public String getPhone() {
        return this.phone;
    }

    /**  **/
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**  **/
    public String getAddress() {
        return this.address;
    }

    /**  **/
    public void setAddress(String address) {
        this.address = address;
    }
    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }
}
