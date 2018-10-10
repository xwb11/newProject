package com.adc.da.generate.entity;

import java.util.Date;

public class AdminssionsplaninformationVO extends AdminssionsplaninformationEO {

    private String adminssionskey;
    private String schoolkey;
    private String majorkey;
    private Integer adminssionsnumber;
    /**
     * 招生计划创建时间
     */
    @org.springframework.format.annotation.DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date createtime;

    /**
     * 是否发布（1发布，0未发布）
     */
    private Integer ispublish;
    @org.springframework.format.annotation.DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date publishtime;
    @org.springframework.format.annotation.DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date offlinetime;
    @org.springframework.format.annotation.DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date createyear;

    /**
     * 学校省份
     */
    private String provincename;

    /**
     * 学校名称
     */
    private String schoolname;

    /**
     * 专业名称
     */
    private String majorname;

    @Override
    public String getAdminssionskey() {
        return adminssionskey;
    }

    @Override
    public void setAdminssionskey(String adminssionskey) {
        this.adminssionskey = adminssionskey;
    }

    @Override
    public String getSchoolkey() {
        return schoolkey;
    }

    @Override
    public void setSchoolkey(String schoolkey) {
        this.schoolkey = schoolkey;
    }

    @Override
    public String getMajorkey() {
        return majorkey;
    }

    @Override
    public void setMajorkey(String majorkey) {
        this.majorkey = majorkey;
    }

    @Override
    public Integer getAdminssionsnumber() {
        return adminssionsnumber;
    }

    @Override
    public void setAdminssionsnumber(Integer adminssionsnumber) {
        this.adminssionsnumber = adminssionsnumber;
    }

    @Override
    public Date getCreatetime() {
        return createtime;
    }

    @Override
    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    @Override
    public Integer getIspublish() {
        return ispublish;
    }

    @Override
    public void setIspublish(Integer ispublish) {
        this.ispublish = ispublish;
    }

    @Override
    public Date getPublishtime() {
        return publishtime;
    }

    @Override
    public void setPublishtime(Date publishtime) {
        this.publishtime = publishtime;
    }

    @Override
    public Date getOfflinetime() {
        return offlinetime;
    }

    @Override
    public void setOfflinetime(Date offlinetime) {
        this.offlinetime = offlinetime;
    }

    @Override
    public Date getCreateyear() {
        return createyear;
    }

    @Override
    public void setCreateyear(Date createyear) {
        this.createyear = createyear;
    }

    public String getProvincename() {
        return provincename;
    }

    public void setProvincename(String provincename) {
        this.provincename = provincename;
    }

    public String getSchoolname() {
        return schoolname;
    }

    public void setSchoolname(String schoolname) {
        this.schoolname = schoolname;
    }

    public String getMajorname() {
        return majorname;
    }

    public void setMajorname(String majorname) {
        this.majorname = majorname;
    }
}
