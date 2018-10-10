package com.adc.da.generate.entity;

import com.adc.da.base.entity.BaseEntity;

import java.util.Date;

/**
 * <b>功能：</b>ADMINSSIONSPLANINFORMATION AdminssionsplaninformationEOEntity<br>
 * <b>作者：</b>code generator<br>
 * <b>日期：</b> 2018-10-08 <br>
 * <b>版权所有：<b>版权归北京卡达克数据技术中心所有。<br>
 */
public class AdminssionsplaninformationEO extends BaseEntity {

    private String adminssionskey;
    private String schoolkey;
    private String majorkey;
    private Integer adminssionsnumber;
    @org.springframework.format.annotation.DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date createtime;
    private Integer ispublish;
    @org.springframework.format.annotation.DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date publishtime;
    @org.springframework.format.annotation.DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date offlinetime;
    @org.springframework.format.annotation.DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date createyear;

    /**
     * java字段名转换为原始数据库列名。<b>如果不存在则返回null</b><br>
     * <p>字段列表：</p>
     * <li>adminssionskey -> adminssionskey</li>
     * <li>schoolkey -> schoolkey</li>
     * <li>majorkey -> majorkey</li>
     * <li>adminssionsnumber -> adminssionsnumber</li>
     * <li>createtime -> createtime</li>
     * <li>ispublish -> ispublish</li>
     * <li>publishtime -> publishtime</li>
     * <li>offlinetime -> offlinetime</li>
     * <li>createyear -> createyear</li>
     */
    public static String fieldToColumn(String fieldName) {
        if (fieldName == null) return null;
        switch (fieldName) {
            case "adminssionskey": return "adminssionskey";
            case "schoolkey": return "schoolkey";
            case "majorkey": return "majorkey";
            case "adminssionsnumber": return "adminssionsnumber";
            case "createtime": return "createtime";
            case "ispublish": return "ispublish";
            case "publishtime": return "publishtime";
            case "offlinetime": return "offlinetime";
            case "createyear": return "createyear";
            default: return null;
        }
    }

    /**
     * 原始数据库列名转换为java字段名。<b>如果不存在则返回null</b><br>
     * <p>字段列表：</p>
     * <li>adminssionskey -> adminssionskey</li>
     * <li>schoolkey -> schoolkey</li>
     * <li>majorkey -> majorkey</li>
     * <li>adminssionsnumber -> adminssionsnumber</li>
     * <li>createtime -> createtime</li>
     * <li>ispublish -> ispublish</li>
     * <li>publishtime -> publishtime</li>
     * <li>offlinetime -> offlinetime</li>
     * <li>createyear -> createyear</li>
     */
    public static String columnToField(String columnName) {
        if (columnName == null) return null;
        switch (columnName) {
            case "adminssionskey": return "adminssionskey";
            case "schoolkey": return "schoolkey";
            case "majorkey": return "majorkey";
            case "adminssionsnumber": return "adminssionsnumber";
            case "createtime": return "createtime";
            case "ispublish": return "ispublish";
            case "publishtime": return "publishtime";
            case "offlinetime": return "offlinetime";
            case "createyear": return "createyear";
            default: return null;
        }
    }
    
    /**  **/
    public String getAdminssionskey() {
        return this.adminssionskey;
    }

    /**  **/
    public void setAdminssionskey(String adminssionskey) {
        this.adminssionskey = adminssionskey;
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
    public String getMajorkey() {
        return this.majorkey;
    }

    /**  **/
    public void setMajorkey(String majorkey) {
        this.majorkey = majorkey;
    }

    /**  **/
    public Integer getAdminssionsnumber() {
        return this.adminssionsnumber;
    }

    /**  **/
    public void setAdminssionsnumber(Integer adminssionsnumber) {
        this.adminssionsnumber = adminssionsnumber;
    }

    /**  **/
    public Date getCreatetime() {
        return this.createtime;
    }

    /**  **/
    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    /**  **/
    public Integer getIspublish() {
        return this.ispublish;
    }

    /**  **/
    public void setIspublish(Integer ispublish) {
        this.ispublish = ispublish;
    }

    /**  **/
    public Date getPublishtime() {
        return this.publishtime;
    }

    /**  **/
    public void setPublishtime(Date publishtime) {
        this.publishtime = publishtime;
    }

    /**  **/
    public Date getOfflinetime() {
        return this.offlinetime;
    }

    /**  **/
    public void setOfflinetime(Date offlinetime) {
        this.offlinetime = offlinetime;
    }

    /**  **/
    public Date getCreateyear() {
        return this.createyear;
    }

    /**  **/
    public void setCreateyear(Date createyear) {
        this.createyear = createyear;
    }

}
