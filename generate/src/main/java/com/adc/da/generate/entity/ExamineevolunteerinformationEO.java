package com.adc.da.generate.entity;

import com.adc.da.base.entity.BaseEntity;

import java.util.Date;

/**
 * <b>功能：</b>EXAMINEEVOLUNTEERINFORMATION ExamineevolunteerinformationEOEntity<br>
 * <b>作者：</b>code generator<br>
 * <b>日期：</b> 2018-10-08 <br>
 * <b>版权所有：<b>版权归北京卡达克数据技术中心所有。<br>
 */
public class ExamineevolunteerinformationEO extends BaseEntity {

    private String volunteerkey;
    private String examinationnumber;
    private Integer volunteernumber;
    private String schoolkey;
    private String majorkey;
    @org.springframework.format.annotation.DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date declaretime;
    private Integer admissionstatue;
    @org.springframework.format.annotation.DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date admissiontime;

    /**
     * java字段名转换为原始数据库列名。<b>如果不存在则返回null</b><br>
     * <p>字段列表：</p>
     * <li>volunteerkey -> volunteerkey</li>
     * <li>examinationnumber -> examinationnumber</li>
     * <li>volunteernumber -> volunteernumber</li>
     * <li>schoolkey -> schoolkey</li>
     * <li>majorkey -> majorkey</li>
     * <li>declaretime -> declaretime</li>
     * <li>admissionstatue -> admissionstatue</li>
     * <li>admissiontime -> admissiontime</li>
     */
    public static String fieldToColumn(String fieldName) {
        if (fieldName == null) return null;
        switch (fieldName) {
            case "volunteerkey": return "volunteerkey";
            case "examinationnumber": return "examinationnumber";
            case "volunteernumber": return "volunteernumber";
            case "schoolkey": return "schoolkey";
            case "majorkey": return "majorkey";
            case "declaretime": return "declaretime";
            case "admissionstatue": return "admissionstatue";
            case "admissiontime": return "admissiontime";
            default: return null;
        }
    }

    /**
     * 原始数据库列名转换为java字段名。<b>如果不存在则返回null</b><br>
     * <p>字段列表：</p>
     * <li>volunteerkey -> volunteerkey</li>
     * <li>examinationnumber -> examinationnumber</li>
     * <li>volunteernumber -> volunteernumber</li>
     * <li>schoolkey -> schoolkey</li>
     * <li>majorkey -> majorkey</li>
     * <li>declaretime -> declaretime</li>
     * <li>admissionstatue -> admissionstatue</li>
     * <li>admissiontime -> admissiontime</li>
     */
    public static String columnToField(String columnName) {
        if (columnName == null) return null;
        switch (columnName) {
            case "volunteerkey": return "volunteerkey";
            case "examinationnumber": return "examinationnumber";
            case "volunteernumber": return "volunteernumber";
            case "schoolkey": return "schoolkey";
            case "majorkey": return "majorkey";
            case "declaretime": return "declaretime";
            case "admissionstatue": return "admissionstatue";
            case "admissiontime": return "admissiontime";
            default: return null;
        }
    }
    
    /**  **/
    public String getVolunteerkey() {
        return this.volunteerkey;
    }

    /**  **/
    public void setVolunteerkey(String volunteerkey) {
        this.volunteerkey = volunteerkey;
    }

    /**  **/
    public String getExaminationnumber() {
        return this.examinationnumber;
    }

    /**  **/
    public void setExaminationnumber(String examinationnumber) {
        this.examinationnumber = examinationnumber;
    }

    /**  **/
    public Integer getVolunteernumber() {
        return this.volunteernumber;
    }

    /**  **/
    public void setVolunteernumber(Integer volunteernumber) {
        this.volunteernumber = volunteernumber;
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
    public Date getDeclaretime() {
        return this.declaretime;
    }

    /**  **/
    public void setDeclaretime(Date declaretime) {
        this.declaretime = declaretime;
    }

    /**  **/
    public Integer getAdmissionstatue() {
        return this.admissionstatue;
    }

    /**  **/
    public void setAdmissionstatue(Integer admissionstatue) {
        this.admissionstatue = admissionstatue;
    }

    /**  **/
    public Date getAdmissiontime() {
        return this.admissiontime;
    }

    /**  **/
    public void setAdmissiontime(Date admissiontime) {
        this.admissiontime = admissiontime;
    }

}
