package com.adc.da.generate.VO;

import com.adc.da.generate.entity.RecruitpeopleEO;

/**
 * @Auther: XWB
 * @Date: 2018/11/10 21:34
 * @Description: 封装招募者信息和项目名称
 */
public class RecruitpeopleVO extends RecruitpeopleEO{

    private String projectName;
    private String projectType;
    private String recruitQuestion;
    private String briefintroduction;
    private Integer projectBudget;

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

    public Integer getProjectBudget() {
        return projectBudget;
    }

    public void setProjectBudget(Integer projectBudget) {
        this.projectBudget = projectBudget;
    }
}
