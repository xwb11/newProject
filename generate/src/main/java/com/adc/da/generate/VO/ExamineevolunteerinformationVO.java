package com.adc.da.generate.VO;

import com.adc.da.generate.entity.ExamineevolunteerinformationEO;

import java.util.Date;
import java.util.List;

public class ExamineevolunteerinformationVO extends ExamineevolunteerinformationEO {
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
     * 学校名称
     */
    private String schoolname;

    /**
     * 学校简介
     */
    private String briefintroduction;

    /**
     * 学校电话
     */
    private String phone;

    /**
     * 学校地址
     */
    private String address;

    //刘笑天添加 20181011 list volunteers
    public List<ExamineevolunteerinformationEO> list;
    public List<ExamineevolunteerinformationEO> volunteers;
    public List<ExamineevolunteerinformationEO> getList() {
        return list;
    }

    public void setList(List<ExamineevolunteerinformationEO> list) {
        this.list = list;
    }

    public List<ExamineevolunteerinformationEO> getVolunteers() {
        return volunteers;
    }

    public void setVolunteers(List<ExamineevolunteerinformationEO> volunteers) {
        this.volunteers = volunteers;
    }

    @Override
    public String getVolunteerkey() {
        return volunteerkey;
    }

    @Override
    public void setVolunteerkey(String volunteerkey) {
        this.volunteerkey = volunteerkey;
    }

    @Override
    public String getExaminationnumber() {
        return examinationnumber;
    }

    @Override
    public void setExaminationnumber(String examinationnumber) {
        this.examinationnumber = examinationnumber;
    }

    @Override
    public Integer getVolunteernumber() {
        return volunteernumber;
    }

    @Override
    public void setVolunteernumber(Integer volunteernumber) {
        this.volunteernumber = volunteernumber;
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
    public Date getDeclaretime() {
        return declaretime;
    }

    @Override
    public void setDeclaretime(Date declaretime) {
        this.declaretime = declaretime;
    }

    @Override
    public Integer getAdmissionstatue() {
        return admissionstatue;
    }

    @Override
    public void setAdmissionstatue(Integer admissionstatue) {
        this.admissionstatue = admissionstatue;
    }

    @Override
    public Date getAdmissiontime() {
        return admissiontime;
    }

    @Override
    public void setAdmissiontime(Date admissiontime) {
        this.admissiontime = admissiontime;
    }

    public String getSchoolname() {
        return schoolname;
    }

    public void setSchoolname(String schoolname) {
        this.schoolname = schoolname;
    }

    public String getBriefintroduction() {
        return briefintroduction;
    }

    public void setBriefintroduction(String briefintroduction) {
        this.briefintroduction = briefintroduction;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
