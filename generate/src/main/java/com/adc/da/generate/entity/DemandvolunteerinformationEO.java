package com.adc.da.generate.entity;

import com.adc.da.base.entity.BaseEntity;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * <b>功能：</b>DEMANDVOLUNTEERINFORMATION DemandvolunteerinformationEOEntity<br>
 * <b>作者：</b>code generator<br>
 * <b>日期：</b> 2018-11-08 <br>
 * <b>版权所有：<b>版权归北京卡达克数据技术中心所有。<br>
 */
public class DemandvolunteerinformationEO extends BaseEntity {

    private String demandKey;
    private String demandRequest;
    private String projectKey;
    private String companyKey;
    private String submissionTime;
    @org.springframework.format.annotation.DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    private Integer isPublish;
    @org.springframework.format.annotation.DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date publishTime;
//    @org.springframework.format.a nnotation.DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    private Date offlineTime;

    /**
     * java字段名转换为原始数据库列名。<b>如果不存在则返回null</b><br>
     * <p>字段列表：</p>
     * <li>demandKey -> demand_key</li>
     * <li>demandRequest -> demand_request</li>
     * <li>projectKey -> project_key</li>
     * <li>companyKey -> company_key</li>
     * <li>submissionTime -> submission_time</li>
     * <li>createTime -> create_time</li>
     * <li>isPublish -> is_publish</li>
     * <li>publishTime -> publish_time</li>
     */
    public static String fieldToColumn(String fieldName) {
        if (fieldName == null) return null;
        switch (fieldName) {
            case "demandKey": return "demand_key";
            case "demandRequest": return "demand_request";
            case "projectKey": return "project_key";
            case "companyKey": return "company_key";
            case "submissionTime": return "submission_time";
            case "createTime": return "create_time";
            case "isPublish": return "is_publish";
            case "publishTime": return "publish_time";
            case "offlineTime": return "offline_time";
            default: return null;
        }
    }

    /**
     * 原始数据库列名转换为java字段名。<b>如果不存在则返回null</b><br>
     * <p>字段列表：</p>
     * <li>demand_key -> demandKey</li>
     * <li>demand_request -> demandRequest</li>
     * <li>project_key -> projectKey</li>
     * <li>company_key -> companyKey</li>
     * <li>submission_time -> submissionTime</li>
     * <li>create_time -> createTime</li>
     * <li>is_publish -> isPublish</li>
     * <li>publish_time -> publishTime</li>
     */
    public static String columnToField(String columnName) {
        if (columnName == null) return null;
        switch (columnName) {
            case "demand_key": return "demandKey";
            case "demand_request": return "demandRequest";
            case "project_key": return "projectKey";
            case "company_key": return "companyKey";
            case "submission_time": return "submissionTime";
            case "create_time": return "createTime";
            case "is_publish": return "isPublish";
            case "publish_time": return "publishTime";
            case "offlineTime": return "offline_time";
            default: return null;
        }
    }
    
    /**  **/
    public String getDemandKey() {
        return this.demandKey;
    }

    /**  **/
    public void setDemandKey(String demandKey) {
        this.demandKey = demandKey;
    }

    /**  **/
    public String getDemandRequest() {
        return this.demandRequest;
    }

    /**  **/
    public void setDemandRequest(String demandRequest) {
        this.demandRequest = demandRequest;
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
    public String getCompanyKey() {
        return this.companyKey;
    }

    /**  **/
    public void setCompanyKey(String companyKey) {
        this.companyKey = companyKey;
    }

    /**  **/
    public String getSubmissionTime() {
        return this.submissionTime;
    }

    /**  **/
    public void setSubmissionTime(String submissionTime) {
        this.submissionTime = submissionTime;
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
    public Integer getIsPublish() {
        return this.isPublish;
    }

    /**  **/
    public void setIsPublish(Integer isPublish) {
        this.isPublish = isPublish;
    }

    /**  **/
    public Date getPublishTime() {
        return this.publishTime;
    }

    /**  **/
    public void setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
    }

    public Date getOfflineTime() {
        return offlineTime;
    }

    public void setOfflineTime(Date offlineTime) {
        this.offlineTime = offlineTime;
    }
}
