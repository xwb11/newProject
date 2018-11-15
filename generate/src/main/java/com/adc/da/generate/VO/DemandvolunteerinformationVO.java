package com.adc.da.generate.VO;

import com.adc.da.generate.entity.DemandvolunteerinformationEO;

import java.util.Date;

/**
 * @Auther: XWB
 * @Date: 2018/11/9 09:30
 * @Description: 封装公司和项目类  需求信息录取实体类
 */
public class DemandvolunteerinformationVO extends DemandvolunteerinformationEO {

    private String projectKey;
    private String projectName;
    //项目类型
    private String projectType;
    private String recruitQuestion;
    //项目描述
    private String briefintroduction;
    private String projectindustry;
    //项目预算
    private Integer projectBudget;

    private String companyKey;
    private String provinceName;
    private String companyName;
    private String phone;
    private String address;
    private String filePath;
    //企业描述
    private String companyBriefintroduction;
    //企业资质
    private String companyNumber;
    private String companyType;

    @Override
    public String getProjectKey() {
        return projectKey;
    }

    @Override
    public void setProjectKey(String projectKey) {
        this.projectKey = projectKey;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }


    public String getProjectType() {
        return projectType;
    }

    public void setProjectType(String projectType) {
        this.projectType = projectType;
    }

    public String getRecruitQuestion() {
        return recruitQuestion;
    }

    public void setRecruitQuestion(String recruitQuestion) {
        this.recruitQuestion = recruitQuestion;
    }

    public String getBriefintroduction() {
        return briefintroduction;
    }

    public void setBriefintroduction(String briefintroduction) {
        this.briefintroduction = briefintroduction;
    }

    public String getProjectindustry() {
        return projectindustry;
    }

    public void setProjectindustry(String projectindustry) {
        this.projectindustry = projectindustry;
    }

    public Integer getProjectBudget() {
        return projectBudget;
    }

    public void setProjectBudget(Integer projectBudget) {
        this.projectBudget = projectBudget;
    }

    @Override
    public String getCompanyKey() {
        return companyKey;
    }

    @Override
    public void setCompanyKey(String companyKey) {
        this.companyKey = companyKey;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
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

    public String getCompanyNumber() {
        return companyNumber;
    }

    public void setCompanyNumber(String companyNumber) {
        this.companyNumber = companyNumber;
    }

    public String getCompanyType() {
        return companyType;
    }

    public void setCompanyType(String companyType) {
        this.companyType = companyType;
    }

    public String getCompanyBriefintroduction() {
        return companyBriefintroduction;
    }

    public void setCompanyBriefintroduction(String companyBriefintroduction) {
        this.companyBriefintroduction = companyBriefintroduction;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
}
