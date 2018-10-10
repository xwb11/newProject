package com.adc.da.generate.entity;

import com.adc.da.base.entity.BaseEntity;

import java.util.Date;

/**
 * <b>功能：</b>MAJORINFORMATION MajorinformationEOEntity<br>
 * <b>作者：</b>code generator<br>
 * <b>日期：</b> 2018-10-08 <br>
 * <b>版权所有：<b>版权归北京卡达克数据技术中心所有。<br>
 */
public class MajorinformationEO extends BaseEntity {

    private String majorkey;
    private String majorname;
    @org.springframework.format.annotation.DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date createtime;

    /**
     * java字段名转换为原始数据库列名。<b>如果不存在则返回null</b><br>
     * <p>字段列表：</p>
     * <li>majorkey -> majorkey</li>
     * <li>majorname -> majorname</li>
     * <li>createtime -> createtime</li>
     */
    public static String fieldToColumn(String fieldName) {
        if (fieldName == null) return null;
        switch (fieldName) {
            case "majorkey": return "majorkey";
            case "majorname": return "majorname";
            case "createtime": return "createtime";
            default: return null;
        }
    }

    /**
     * 原始数据库列名转换为java字段名。<b>如果不存在则返回null</b><br>
     * <p>字段列表：</p>
     * <li>majorkey -> majorkey</li>
     * <li>majorname -> majorname</li>
     * <li>createtime -> createtime</li>
     */
    public static String columnToField(String columnName) {
        if (columnName == null) return null;
        switch (columnName) {
            case "majorkey": return "majorkey";
            case "majorname": return "majorname";
            case "createtime": return "createtime";
            default: return null;
        }
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
    public String getMajorname() {
        return this.majorname;
    }

    /**  **/
    public void setMajorname(String majorname) {
        this.majorname = majorname;
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
