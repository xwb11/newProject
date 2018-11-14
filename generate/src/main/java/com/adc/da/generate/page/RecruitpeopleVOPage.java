package com.adc.da.generate.page;

/**
 * @Auther: XWB
 * @Date: 2018/11/10 21:36
 * @Description:
 */
public class RecruitpeopleVOPage extends RecruitpeopleEOPage {

    private String projectName;
    private String projectNameOperator = "=";
    private String projectType;
    private String projectTypeOperator = "=";
    private String recruitQuestion;
    private String recruitQuestionOperator = "=";
    private String briefintroduction;
    private String briefintroductionOperator = "=";
    private String projectBudget;
    private String projectBudgetOperator = "=";

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectNameOperator() {
        return projectNameOperator;
    }

    public void setProjectNameOperator(String projectNameOperator) {
        this.projectNameOperator = projectNameOperator;
    }

    public String getProjectType() {
        return projectType;
    }

    public void setProjectType(String projectType) {
        this.projectType = projectType;
    }

    public String getProjectTypeOperator() {
        return projectTypeOperator;
    }

    public void setProjectTypeOperator(String projectTypeOperator) {
        this.projectTypeOperator = projectTypeOperator;
    }

    public String getRecruitQuestion() {
        return recruitQuestion;
    }

    public void setRecruitQuestion(String recruitQuestion) {
        this.recruitQuestion = recruitQuestion;
    }

    public String getRecruitQuestionOperator() {
        return recruitQuestionOperator;
    }

    public void setRecruitQuestionOperator(String recruitQuestionOperator) {
        this.recruitQuestionOperator = recruitQuestionOperator;
    }

    public String getBriefintroduction() {
        return briefintroduction;
    }

    public void setBriefintroduction(String briefintroduction) {
        this.briefintroduction = briefintroduction;
    }

    public String getBriefintroductionOperator() {
        return briefintroductionOperator;
    }

    public void setBriefintroductionOperator(String briefintroductionOperator) {
        this.briefintroductionOperator = briefintroductionOperator;
    }

    public String getProjectBudget() {
        return projectBudget;
    }

    public void setProjectBudget(String projectBudget) {
        this.projectBudget = projectBudget;
    }

    public String getProjectBudgetOperator() {
        return projectBudgetOperator;
    }

    public void setProjectBudgetOperator(String projectBudgetOperator) {
        this.projectBudgetOperator = projectBudgetOperator;
    }
}
