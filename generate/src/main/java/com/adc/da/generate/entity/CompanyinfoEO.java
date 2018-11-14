package com.adc.da.generate.entity;

import com.adc.da.base.entity.BaseEntity;

import java.util.Date;

/**
 * <b>功能：</b>COMPANYINFO CompanyinfoEOEntity<br>
 * <b>作者：</b>code generator<br>
 * <b>日期：</b> 2018-11-08 <br>
 * <b>版权所有：<b>版权归北京卡达克数据技术中心所有。<br>
 */
public class CompanyinfoEO extends BaseEntity {

    private String companyKey;
    private String provinceName;
    private String companyName;
    private String companyBriefintroduction;
    private String phone;
    private String address;
    @org.springframework.format.annotation.DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date createtime;
    private String companyNumber;
    private String companyType;
    //开发者类型
    private String developerType;
    //文件路径
    private String filePath;

    /**
     * java字段名转换为原始数据库列名。<b>如果不存在则返回null</b><br>
     * <p>字段列表：</p>
     * <li>companyKey -> company_key</li>
     * <li>provinceName -> province_name</li>
     * <li>companyName -> company_name</li>
     * <li>briefintroduction -> briefintroduction</li>
     * <li>phone -> phone</li>
     * <li>address -> address</li>
     * <li>createtime -> createtime</li>
     * <li>companyNumber -> company_number</li>
     * <li>companyType -> company_type</li>
     */
    public static String fieldToColumn(String fieldName) {
        if (fieldName == null) return null;
        switch (fieldName) {
            case "companyKey": return "company_key";
            case "provinceName": return "province_name";
            case "companyName": return "company_name";
            case "companyBriefintroduction": return "company_briefintroduction";
            case "phone": return "phone";
            case "address": return "address";
            case "createtime": return "createtime";
            case "companyNumber": return "company_number";
            case "companyType": return "company_type";
            case "developerType" :return "developer_type";
            case "filePath" :return "file_path";
            default: return null;
        }
    }

    /**
     * 原始数据库列名转换为java字段名。<b>如果不存在则返回null</b><br>
     * <p>字段列表：</p>
     * <li>company_key -> companyKey</li>
     * <li>province_name -> provinceName</li>
     * <li>company_name -> companyName</li>
     * <li>briefintroduction -> briefintroduction</li>
     * <li>phone -> phone</li>
     * <li>address -> address</li>
     * <li>createtime -> createtime</li>
     * <li>company_number -> companyNumber</li>
     * <li>company_type -> companyType</li>
     */
    public static String columnToField(String columnName) {
        if (columnName == null) return null;
        switch (columnName) {
            case "company_key": return "companyKey";
            case "province_name": return "provinceName";
            case "company_name": return "companyName";
            case "company_briefintroduction": return "companyBriefintroduction";
            case "phone": return "phone";
            case "address": return "address";
            case "createtime": return "createtime";
            case "company_number": return "companyNumber";
            case "company_type": return "companyType";
        case "developer_type":return "developerType";
        case "file_path":return "filePath";
            default: return null;
        }
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
    public String getProvinceName() {
        return this.provinceName;
    }

    /**  **/
    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    /**  **/
    public String getCompanyName() {
        return this.companyName;
    }

    /**  **/
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    /**  **/
    public String getCompanyBriefintroduction() {
        return this.companyBriefintroduction;
    }

    /**  **/
    public void setCompanyBriefintroduction(String companyBriefintroduction) {
        this.companyBriefintroduction = companyBriefintroduction;
    }

    /**  **/
    public String getPhone() {
        return this.phone;
    }

    /**  **/
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**  **/
    public String getAddress() {
        return this.address;
    }

    /**  **/
    public void setAddress(String address) {
        this.address = address;
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
    public String getCompanyNumber() {
        return this.companyNumber;
    }

    /**  **/
    public void setCompanyNumber(String companyNumber) {
        this.companyNumber = companyNumber;
    }

    /**  **/
    public String getCompanyType() {
        return this.companyType;
    }

    /**  **/
    public void setCompanyType(String companyType) {
        this.companyType = companyType;
    }

    public String getDeveloperType() {
        return developerType;
    }

    public void setDeveloperType(String developerType) {
        this.developerType = developerType;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

}
