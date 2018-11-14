package com.adc.da.generate.entity;

import com.adc.da.base.entity.BaseEntity;

import java.util.Date;

/**
 * <b>功能：</b>PROJECTINFO ProjectinfoEOEntity<br>
 * <b>作者：</b>code generator<br>
 * <b>日期：</b> 2018-11-08 <br>
 * <b>版权所有：<b>版权归北京卡达克数据技术中心所有。<br>
 */
public class ProjectinfoEO extends BaseEntity {

    private String projectKey;
    private String projectName;
    @org.springframework.format.annotation.DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    private String projectType;
    private String recruitQuestion;
    private String briefintroduction;
    private Integer projectBudget;

    /**
     * java字段名转换为原始数据库列名。<b>如果不存在则返回null</b><br>
     * <p>字段列表：</p>
     * <li>projectKey -> project_key</li>
     * <li>projectName -> project_name</li>
     * <li>createTime -> create_time</li>
     * <li>projectType -> project_type</li>
     * <li>recruitQuestion -> recruit_question</li>
     * <li>briefintroduction -> briefintroduction</li>
     * <li>projectindustry -> project_industry</li>
     * <li>projectBudget -> project_budget</li>
     * <li>userKey -> user_key</li>
     */
    public static String fieldToColumn(String fieldName) {
        if (fieldName == null) return null;
        switch (fieldName) {
            case "projectKey": return "project_key";
            case "projectName": return "project_name";
            case "createTime": return "create_time";
            case "projectType": return "project_type";
            case "recruitQuestion": return "recruit_question";
            case "briefintroduction": return "briefintroduction";
            case "projectBudget": return "project_budget";
            default: return null;
        }
    }

    /**
     * 原始数据库列名转换为java字段名。<b>如果不存在则返回null</b><br>
     * <p>字段列表：</p>
     * <li>project_key -> projectKey</li>
     * <li>project_name -> projectName</li>
     * <li>create_time -> createTime</li>
     * <li>project_type -> projectType</li>
     * <li>recruit_question -> recruitQuestion</li>
     * <li>briefintroduction -> briefintroduction</li>
     * <li>project_industry -> projectindustry</li>
     * <li>project_budget -> projectBudget</li>
     * <li>user_key -> userKey</li>
     */
    public static String columnToField(String columnName) {
        if (columnName == null) return null;
        switch (columnName) {
            case "project_key": return "projectKey";
            case "project_name": return "projectName";
            case "create_time": return "createTime";
            case "project_type": return "projectType";
            case "recruit_question": return "recruitQuestion";
            case "briefintroduction": return "briefintroduction";
            case "project_budget": return "projectBudget";
            default: return null;
        }
    }
    
    /**  **/
    public String getProjectKey() {
        return this.projectKey;
    }

    /**  **/
    public void setProjectKey(String projectKey) {
        this.projectKey = projectKey;
    }

    /**  **/
    public String getProjectName() {
        return this.projectName;
    }

    /**  **/
    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    /**  **/
    public Date getCreateTime() {
        return this.createTime;
    }

    /**  **/
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**  **/
    public String getProjectType() {
        return this.projectType;
    }

    /**  **/
    public void setProjectType(String projectType) {
        this.projectType = projectType;
    }

    /**  **/
    public String getRecruitQuestion() {
        return this.recruitQuestion;
    }

    /**  **/
    public void setRecruitQuestion(String recruitQuestion) {
        this.recruitQuestion = recruitQuestion;
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
    public Integer getProjectBudget() {
        return this.projectBudget;
    }

    /**  **/
    public void setProjectBudget(Integer projectBudget) {
        this.projectBudget = projectBudget;
    }

}
